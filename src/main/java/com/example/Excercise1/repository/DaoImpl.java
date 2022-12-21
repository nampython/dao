package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.GetDataException;
import com.example.Excercise1.exceptions.SetDataException;
import com.example.Excercise1.utils.ErrorCodeMap;
import com.example.Excercise1.valueObject.Value;
import com.example.Excercise1.valueObject.ValueObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.Excercise1.constants.MessageException.*;

@Repository
public class DaoImpl implements Dao {

    private static final Logger log = LogManager.getLogger(DaoImpl.class);
    private final Environment env;
    private final RepositoryFunc repositoryFunc;

    @Autowired
    public DaoImpl(Environment env, RepositoryFunc repositoryFunc) {
        this.env = env;
        this.repositoryFunc = repositoryFunc;
    }

    /**
     * Use to get a list of value objects
     *
     * @param sql:             sql query
     * @param valueObjectClass The class of the value object.
     * @param <T>:
     * @return a ValueObject that can be downcasted to valueObjectClass
     * @throws GetDataException if the record was not found
     */
    @Override
    public <T extends ValueObject> List<T> getListOfValueObject(String sql, Class<T> valueObjectClass) throws GetDataException {
        List<T> valueObjects = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            log.info("message=Executing sql: " + sql + " with " + "valueObject: " + valueObjectClass.getSimpleName());
            connection = repositoryFunc.getConnection();
            stmt = connection.createStatement();
//            stmt.setFetchSize(getFetchSize());
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                T valueObject = valueObjectClass.getConstructor().newInstance();
                valueObject.parseSql(rs);
                valueObjects.add((T) valueObject);
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new GetDataException(String.format(FAILED_TO_GET_DATA, sql, valueObjects), e.getCause());
        } finally {
            repositoryFunc.closeStatement(stmt);
            repositoryFunc.closeConnection(connection);
        }
        return valueObjects;
    }

    @Override
    public <T extends ValueObject> T getSingleValueObject(String sql, Class<T> valueObjectClass) {
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        T valueObject = null;
        try {
            log.info("message=Executing sql: " + sql + " with " + "valueObject: " + valueObjectClass.getSimpleName());
            cn = repositoryFunc.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                valueObject = valueObjectClass.getConstructor().newInstance();
                valueObject.parseSql(rs);
            }
            return valueObject;
        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Use to get list of value object with preparedStatement
     *
     * @param sql              sql query
     * @param params           the parameter to use in the sql qeury
     * @param valueObjectClass The class of the value object.
     * @param <T>:
     * @return a ValueObject that can be downcasted to valueObjectClass
     */
    @Override
    public <T extends ValueObject> List<T> getListOfValueObjectWithPreparedStatement(String sql, List<Object> params, Class<T> valueObjectClass) {
        List<T> valueObjects = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            log.info("message=Executing sql: " + sql + "with params: " + params.toString() + " and " + " valueObject: " + valueObjectClass.getSimpleName());
            connection = repositoryFunc.getConnection();
            ps = connection.prepareStatement(sql);
            repositoryFunc.setSearchParams(ps, params);
            rs = ps.executeQuery();
            while (rs.next()) {
                T valueObject = valueObjectClass.getConstructor().newInstance();
                valueObject.parseSql(rs);
                valueObjects.add((T) valueObject);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new GetDataException(String.format(FAILED_TO_GET_DATA, sql, valueObjects), e.getCause());
        } finally {
            repositoryFunc.closeStatement(ps);
            repositoryFunc.closeConnection(connection);
        }

        return valueObjects;
    }

    /**
     * use to get a single value object
     *
     * @param sql              sql query
     * @param params           the parameter to use in the sql qeury
     * @param valueObjectClass The class of the value object.
     * @param <T>:
     * @return a value object
     */
    @Override
    public <T extends ValueObject> T getSingleValueObjectWithPreparedStatement(String sql, List<Object> params, Class<T> valueObjectClass) {
        T valueObject = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            log.info("message=Executing sql: " + sql + " with params: " + params.toString() + " and valueObject: " + valueObjectClass.getSimpleName());
            connection = repositoryFunc.getConnection();
            valueObject = valueObjectClass.getConstructor().newInstance();
            preparedStatement = connection.prepareStatement(sql);
            repositoryFunc.setSearchParams(preparedStatement, params);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                valueObject.parseSql(rs);
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new GetDataException(String.format(FAILED_TO_GET_DATA, sql, valueObject), e.getCause());
        } finally {
            repositoryFunc.closeStatement(preparedStatement);
            repositoryFunc.closeConnection(connection);
        }
        return (T) valueObject;
    }

    /**
     * Use to get multiple rows
     *
     * @param sql  sql query
     * @param <T>:
     * @return Multiple Row
     */
    @Override
    public <T extends ValueObject> List<List<Value>> getMultipleRowsWithStatement(String sql) {
        List<List<Value>> rows = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        ResultSetMetaData meta = null;
        int count = 0;
        try {
            log.info("message=Executing sql: " + sql + "(get multiple rows)");
            cn = repositoryFunc.getConnection();
            // sql = processParams(sql, params);
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            repositoryFunc.getMultipleRows(rs, rows);
        } catch (SQLException e) {
            throw new GetDataException(String.format(FAILED_TO_GET_MULTIPLE_ROW, sql), e.getCause());
        } finally {
            repositoryFunc.closeStatement(st);
            repositoryFunc.closeConnection(cn);
        }
        return rows;
    }

    /**
     * Use to get single row data
     *
     * @param sql  sql query
     * @param <T>:
     * @return single row
     */
    @Override
    public <T extends ValueObject> List<Value> getSingleRow(String sql) {
        List<Value> values = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        ResultSetMetaData meta = null;
        int count = 0;
        try {
            cn = repositoryFunc.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                meta = rs.getMetaData();
                count = meta.getColumnCount();
                for (int i = 1; i <= count; i++) {
                    Object obj = rs.getObject(i);
                    values.add(new Value(obj));
                }
            }
        } catch (SQLException e) {
            throw new GetDataException(String.format(FAILED_TO_GET_SINGLE_ROW, sql), e.getCause());
        } finally {
            repositoryFunc.closeStatement(st);
            repositoryFunc.closeConnection(cn);
        }
        return values;
    }

    /**
     * Use to set list of value object
     *
     * @param valueObjects List of valueObjectClass The class of the value object.
     * @throws SQLException
     */
    @Override
    public void setListOfValueObjects(List<ValueObject> valueObjects) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = null;
        List<Object> params = null;
        try {
            conn = repositoryFunc.getConnection();
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
            repositoryFunc.closeStatement(ps);
            repositoryFunc.closeConnection(conn);
        }
    }

    /**
     * @param valueObject valueObjectClass The class of the value object.
     */
    @Override
    public void setValueObject(ValueObject valueObject) throws SQLException {
        boolean isUpdated = valueObject.getResultCode() == ErrorCodeMap.RECORD_FOUND && valueObject.isModified();
        boolean isNewValueObject = valueObject.getResultCode() == ErrorCodeMap.NEW_RECORD;
        boolean isDeletedValueObject = valueObject.getResultCode() == ErrorCodeMap.DELETED_RECORD;

        if (isUpdated || isNewValueObject || isDeletedValueObject) {
            Connection connection = null;
            try {
                connection = repositoryFunc.getConnection();
                this.executeSql(connection, valueObject.getExecuteSql(), valueObject.getParams());
            } finally {
                repositoryFunc.closeConnection(connection);
            }
        }
    }

    public int executeSql(Connection cn, String sql, List<Object> params) {
        PreparedStatement ps = null;
        int rowsAffected = 0;
        try {
            ps = cn.prepareStatement(sql);
            repositoryFunc.setSearchParams(ps, params);
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            throw new SetDataException(String.format(FAILED_TO_EXECUTE, sql , params), e.getCause());
        } finally {
            repositoryFunc.closeStatement(ps);
        }
        return rowsAffected;
    }
}
