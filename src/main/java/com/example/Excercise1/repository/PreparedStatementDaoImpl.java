package com.example.Excercise1.repository;

import com.example.Excercise1.database.ProcessConnection;
import com.example.Excercise1.database.ProcessStatement;
import com.example.Excercise1.exceptions.GetDataException;
import com.example.Excercise1.exceptions.SetDataException;
import com.example.Excercise1.utils.ErrorCodeMap;
import com.example.Excercise1.valueObject.Value;
import com.example.Excercise1.valueObject.ValueObject;
import com.example.Excercise1.valueUtils.SetValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.Excercise1.constants.MessageException.*;

@Repository
public class PreparedStatementDaoImpl implements PreparedStatementDao {
    private static final Logger log = LogManager.getLogger(PreparedStatementDaoImpl.class);
    private final ProcessConnection processConnection;
    private final ProcessStatement processStatement;
    private final RepositoryFunc repositoryFunc;

    @Autowired
    public PreparedStatementDaoImpl(ProcessConnection processConnection, RepositoryFunc repositoryFunc, SetValue setValue, ProcessStatement processStatement) {
        this.processConnection = processConnection;
        this.repositoryFunc = repositoryFunc;
        this.processStatement = processStatement;
    }

    /**
     * Get value objects using sql query and list of params
     * @param sql use to query data
     * @param params use to set data in sql query
     * @return List of values
     */
    @Override
    public List<List<Value>> getValueObjects(String sql, List<Object> params) {
        List<List<Value>> values = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            log.info("message=Executing sql: " + sql + " with params: " + params.toString());
            connection = this.processConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            this.repositoryFunc.setSearchParams(preparedStatement, params);
            rs = preparedStatement.executeQuery();
            this.repositoryFunc.getMultipleRows(rs, values);
            return values;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Use to get list of value object
     *
     * @param sql              sql query
     * @param params           the parameter to use in the sql query
     * @param valueObjectClass The class of the value object.
     * @param <T>:
     * @return a ValueObject that can be downcasted to valueObjectClass
     */
    @Override
    public <T extends ValueObject> List<T> getValueObjects(String sql, List<Object> params, Class<T> valueObjectClass) {
        List<T> valueObjects = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            log.info("message=Executing sql: " + sql + "with params: " + params.toString() + " and " + " valueObject: " + valueObjectClass.getSimpleName());
            connection = processConnection.getConnection();
            ps = connection.prepareStatement(sql);
            repositoryFunc.setSearchParams(ps, params);
            rs = ps.executeQuery();

            while (rs.next()) {
                T valueObject = valueObjectClass.getConstructor().newInstance();
                valueObject.parseSql(rs);
                valueObjects.add((T) valueObject);
            }
            return valueObjects;
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new GetDataException(String.format(FAILED_TO_GET_DATA, sql, valueObjects), e.getCause());
        } finally {
            processStatement.closeStatement(ps);
            processConnection.closeConnection(connection);
        }
    }


    /**
     * Get single value object
     * @param sql
     * @param params
     * @param valueObjectClass
     * @return
     * @param <T>
     */
    @Override
    public <T extends ValueObject> T getSingleValueObject(String sql, List<Object> params, Class<T> valueObjectClass) {
        T valueObject = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            log.info("message=Executing sql: " + sql + " with params: " + params.toString() + " and valueObject: " + valueObjectClass.getSimpleName());
            connection = processConnection.getConnection();
            valueObject = valueObjectClass.getConstructor().newInstance();
            preparedStatement = connection.prepareStatement(sql);
            repositoryFunc.setSearchParams(preparedStatement, params);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                valueObject.parseSql(rs);
            }
            return (T) valueObject;

        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new GetDataException(String.format(FAILED_TO_GET_DATA, sql, valueObject), e.getCause());
        } finally {
            processStatement.closeStatement(preparedStatement);
            processConnection.closeConnection(connection);
        }
    }


    /**
     * Use to set value object into Database. Normally we use it for insert, delete, update queries
     * @param valueObject we want to process
     */
    @Override
    public void setValueObject(ValueObject valueObject) {
        boolean isUpdated = valueObject.getResultCode() == ErrorCodeMap.RECORD_FOUND && valueObject.isModified();
        boolean isNewValueObject = valueObject.getResultCode() == ErrorCodeMap.NEW_RECORD;
        boolean isDeletedValueObject = valueObject.getResultCode() == ErrorCodeMap.DELETED_RECORD;

        if (isUpdated || isNewValueObject || isDeletedValueObject) {
            Connection connection = null;
            try {
                connection = processConnection.getConnection();
                this.executeSql(connection, valueObject.getExecuteSql(), valueObject.getParams());
            } finally {
                processConnection.closeConnection(connection);
            }
        }
    }

    private int executeSql(Connection connection, String sql, List<Object> params) {
        PreparedStatement ps = null;
        int rowsAffected = 0;

        try {
            ps = connection.prepareStatement(sql);
            repositoryFunc.setSearchParams(ps, params);
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            throw new SetDataException(String.format(FAILED_TO_EXECUTE, sql , params), e.getCause());
        } finally {
            processStatement.closeStatement(ps);
        }
        return rowsAffected;
    }

    /**
     * Instead of saving a single valueObject. We will save a list of value objects. Normally we use it for insert, delete, update queries
     *
     * @param valueObjects List of valueObjectClass The class of the value object.
     */
    @Override
    public void setValueObjects(List<ValueObject> valueObjects) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = null;
        List<Object> params = null;

        try {
            conn = processConnection.getConnection();
            conn.setAutoCommit(false);
            for (ValueObject valueObject : valueObjects) {
                sql = valueObject.getExecuteSql();
                params = valueObject.getParams();
                ps = conn.prepareStatement(sql);
                repositoryFunc.setSearchParams(ps, params);
                ps.executeUpdate();
            }
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new SetDataException(FAILED_TO_SAVE_VALUE_OBJECT, e.getCause());
        } finally {
            processStatement.closeStatement(ps);
            processConnection.closeConnection(conn);
        }
    }
}
