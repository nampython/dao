package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.GetDataException;
import com.example.Excercise1.exceptions.SetDataException;
import com.example.Excercise1.valueObject.Value;
import com.example.Excercise1.valueObject.ValueObject;
import org.springframework.stereotype.Repository;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.example.Excercise1.constants.MessageException.*;
import static com.example.Excercise1.repository.FunctionalCommon.*;

@Repository
public class DaoImpl implements Dao {

    /**
     * return a list of value object
     *
     * @param sql:             sql query
     * @param valueObjectClass The class of the value object.
     * @param <T>:
     * @throws GetDataException if the record was not found
     * @return: a ValueObject that can be downcasted to valueObjectClass
     */
    @Override
    public <T extends ValueObject> List<T> getListOfValueObject(String sql, Class<T> valueObjectClass) throws GetDataException {
        List<T> valueObjects = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
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
            throw new GetDataException(FAILED_TO_GET_DATA, e.getCause());
        } finally {
            closeStatement(stmt);
            closeConnection(connection);
        }
        return valueObjects;
    }

    /**
     * get list of value object with preparedStatement
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
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            setSearchParams(ps, params);
            rs = ps.executeQuery();
            while (rs.next()) {
                T valueObject = valueObjectClass.getConstructor().newInstance();
                valueObject.parseSql(rs);
                valueObjects.add((T) valueObject);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new GetDataException(FAILED_TO_GET_DATA);
        } finally {
            closeStatement(ps);
            closeConnection(connection);
        }

        return valueObjects;
    }

    /**
     * get a single value object
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
            connection = getConnection();
            valueObject = valueObjectClass.getConstructor().newInstance();
            preparedStatement = connection.prepareStatement(sql);
            setSearchParams(preparedStatement, params);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                valueObject.parseSql(rs);
            }
        } catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException sqlException) {
            throw new GetDataException(FAILED_TO_GET_DATA);
        } finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
        return (T) valueObject;
    }

    /**
     * Get multiple rows
     * @param sql sql query
     * @return Multiple Row
     * @param <T>:
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
            cn = getConnection();
            // sql = processParams(sql, params);
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            getMultipleRows(rs, rows);
        } catch (SQLException e) {
            throw new GetDataException(FAILED_TO_GET_MULTIPLE_ROW);
        } finally {
            closeStatement(st);
            closeConnection(cn);
        }
        return rows;
    }

    /**
     * Get single row data
     * @param sql sql query
     * @return single row
     * @param <T>:
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
            cn = getConnection();
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
            throw new GetDataException(FAILED_TO_GET_SINGLE_ROW);
        } finally {
            closeStatement(st);
            closeConnection(cn);
        }
        return values;
    }

    /**
     * Set list of value object
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
            conn = getConnection();
            conn.setAutoCommit(false);
            for (ValueObject valueObject : valueObjects) {
                sql = valueObject.getExecuteSql();
                params = valueObject.getParams();
                ps = conn.prepareStatement(sql);
                setSearchParams(ps, params);
                ps.executeUpdate();
            }
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new SetDataException(FAILED_TO_SAVE_VALUE_OBJECT);
        } finally {
            closeStatement(ps);
            closeConnection(conn);
        }
    }

    /**
     * @param valueObject valueObjectClass The class of the value object.
     */
    @Override
    public void setValueObject(ValueObject valueObject) throws SQLException {
        List<Object> params = valueObject.getParams();
        String sql = valueObject.getExecuteSql();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            setSearchParams(preparedStatement, params);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(FAILED_TO_SAVE_VALUE_OBJECT);
        } finally {
            closeStatement(preparedStatement);
            closeConnection(connection);
        }
    }
}
