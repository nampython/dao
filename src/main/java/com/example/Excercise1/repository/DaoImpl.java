package com.example.Excercise1.repository;

import com.example.Excercise1.database.ProcessConnection;
import com.example.Excercise1.database.ProcessStatement;
import com.example.Excercise1.exceptions.GetDataException;
import com.example.Excercise1.valueObject.Value;
import com.example.Excercise1.valueObject.ValueObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.Excercise1.constants.MessageException.*;


@Repository
public class DaoImpl implements Dao {
    private static final Logger log = LogManager.getLogger(DaoImpl.class);
    private final RepositoryFunc repositoryFunc;
    private final ProcessConnection processConnection;
    private final ProcessStatement processStatement;
    @Autowired
    public DaoImpl(RepositoryFunc repositoryFunc, ProcessConnection processConnection, ProcessStatement processStatement) {
        this.repositoryFunc = repositoryFunc;
        this.processConnection = processConnection;
        this.processStatement = processStatement;
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
    public <T extends ValueObject> List<T> getValueObjects(String sql, Class<T> valueObjectClass) throws GetDataException {
        List<T> valueObjects = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            log.info("message=Executing sql: " + sql + " with " + "valueObject: " + valueObjectClass.getSimpleName());
            connection = processConnection.getConnection();
            stmt = connection.createStatement();
//            stmt.setFetchSize(getFetchSize());
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                T valueObject = valueObjectClass.getConstructor().newInstance();
                valueObject.parseSql(rs);
                valueObjects.add((T) valueObject);
            }
            return valueObjects;
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new GetDataException(String.format(FAILED_TO_GET_DATA, sql, valueObjects), e.getCause());
        } finally {
            processStatement.closeStatement(stmt);
            processConnection.closeConnection(connection);
        }
    }

    @Override
    public <T extends ValueObject> T getSingleValueObject(String sql, Class<T> valueObjectClass) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        T valueObject = null;

        try {
            log.info("message=Executing sql: " + sql + " with " + "valueObject: " + valueObjectClass.getSimpleName());
            connection = processConnection.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                valueObject = valueObjectClass.getConstructor().newInstance();
                valueObject.parseSql(rs);
            }
            return valueObject;
        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new GetDataException(String.format(FAILED_TO_GET_DATA, sql, valueObjectClass.getSimpleName()), e.getCause());
        } finally {
            processStatement.closeStatement(stmt);
            processConnection.closeConnection(connection);
        }
    }

    /**
     * Use to get multiple rows
     *
     * @param sql  sql query
     * @param <T>:
     * @return Multiple Row
     */
    @Override
    public <T extends ValueObject> List<List<Value>> getMultipleRows(String sql) {
        List<List<Value>> rows = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            log.info("message=Executing sql: " + sql + "(get multiple rows)");
            cn = processConnection.getConnection();
            // sql = processParams(sql, params);
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            repositoryFunc.getMultipleRows(rs, rows);
        } catch (SQLException e) {
            throw new GetDataException(String.format(FAILED_TO_GET_MULTIPLE_ROW, sql), e.getCause());
        } finally {
            processStatement.closeStatement(st);
            processConnection.closeConnection(cn);
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
            cn = processConnection.getConnection();
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
            processStatement.closeStatement(st);
            processConnection.closeConnection(cn);
        }
        return values;
    }
}
