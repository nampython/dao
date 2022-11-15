package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.XifinDataNotFoundException;
import com.example.Excercise1.mars.ValueObject;
import com.example.Excercise1.persistence.ErrorCodeMap;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.example.Excercise1.repository.FunctionalCommon.getConnection;

@Repository
public class DaoImpl implements Dao {


    private static final Logger log = Logger.getLogger(DaoImpl.class);

    /**
     *
     * @param sql
     * @param valueObjectClass
     * @return
     * @param <T>
     * @throws XifinDataNotFoundException
     */
    @Override
    public <T extends ValueObject> List<T> getValueObject(String sql, Class<T> valueObjectClass) throws XifinDataNotFoundException {
        List<T> valueObjects = new ArrayList<T>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stmt = connection.createStatement();
//            stmt.setFetchSize(getFetchSize());
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ValueObject valueObject = valueObjectClass.getConstructor().newInstance();
                valueObject.parseSql(rs);
                valueObject.setResultCode(ErrorCodeMap.RECORD_FOUND);
                valueObjects.add((T) valueObject);
            }
        } catch (Exception e) {
            throw new XifinDataNotFoundException("failure to get value objects " + sql, e);
        } finally {
            FunctionalCommon.closeStatement(stmt);
            FunctionalCommon.closeConnection(connection);
        }

        return valueObjects;

    }

    /**
     * @param sql
     * @param params
     * @param valueObjectClass
     * @param <T>
     * @return
     */
    @Override
    public <T extends ValueObject> T getValueObject(String sql, List params, Class<T> valueObjectClass) throws XifinDataNotFoundException {
        ValueObject valueObject = null;
        try {
            valueObject = valueObjectClass.newInstance();
            loadValueObject(sql, params, valueObject);
        } catch (Exception e) {
            throw new XifinDataNotFoundException("Unable to create instance of valueObjectClass" + valueObjectClass, e);
        }

        return (T) valueObject;
    }

    @Override
    public <T extends ValueObject> List<T> getValueObjects(String sql, List params, Class<T> valueObjectClass) {
        List<T> valueObjects = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            FunctionalCommon.setSearchParams(ps, params);
            rs = ps.executeQuery();
            while (rs.next()) {
                ValueObject valueObject = valueObjectClass.newInstance();
                valueObject.parseSql(rs);
                valueObjects.add((T) valueObject);
            }
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return valueObjects;
    }

    @Override
    public <T extends ValueObject> List<List<Value>> getMultipleRows(String sql, List params) {
        List<List<Value>> rows = new ArrayList<List<Value>>();
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
            while (rs.next()) {
//                ResultSetMetaData meta = rs.getMetaData();
                meta = rs.getMetaData();
                count = meta.getColumnCount();
                if (count <= 0) {
                    continue;
                }
                List<Value> columns = new ArrayList<>();
                for (int i = 1; i <= count; i++) {
                    Object obj = rs.getObject(i);
                    columns.add(new Value(obj));
                }
                rows.add(columns);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FunctionalCommon.closeStatement(st);
            FunctionalCommon.closeConnection(cn);
        }
        return rows;
    }

    @Override
    public <T extends ValueObject> List<Value> getSingleRow(String sql, List params) {
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
            throw new RuntimeException(e);
        }
        finally {
            FunctionalCommon.closeStatement(st);
            FunctionalCommon.closeConnection(cn);
        }
        return values;
    }

    /**
     *
     * @param valueObject
     */
    @Override
    public void setValueObject(ValueObject valueObject) throws SQLException {
        excuteSQL(valueObject, valueObject.getExecuteSql(), valueObject.getParams());
    }

    @Override
    public void setValueObjects(List<ValueObject> valueObjects) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = null;
        List params = null;
        try {
            conn = FunctionalCommon.getConnection();
            conn.setAutoCommit(false);
            for (ValueObject valueObject : valueObjects) {
                sql = valueObject.getExecuteSql();
                params = valueObject.getParams();
                ps = conn.prepareStatement(sql);
                FunctionalCommon.setSearchParams(ps, params);
                ps.executeUpdate();
            }
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            FunctionalCommon.closeStatement(ps);
            FunctionalCommon.closeConnection(conn);
        }
    }

    @Override
    public int getMaxId(String sql) throws SQLException {
        Connection  connection = null;
        Statement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.createStatement();
            rs = ps.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                //
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FunctionalCommon.closeStatement(ps);
            FunctionalCommon.closeConnection(connection);
        }

        return 0;
    }

    public void excuteSQL(ValueObject valueObject, String sql, List params) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            FunctionalCommon.setSearchParams(ps, params);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FunctionalCommon.closeStatement(ps);
            FunctionalCommon.closeConnection(connection);
        }
    }

    private void loadValueObject(String sql, List params, ValueObject valueObject) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cn = getConnection();
//            sql = processParams(sql, params);
            ps = cn.prepareStatement(sql);
//            ps.setString(1, "Classic Cars");
            FunctionalCommon.setSearchParams(ps, params);
            rs = ps.executeQuery();
            if (rs.next()) {
                valueObject.parseSql(rs);
                valueObject.setResultCode(ErrorCodeMap.RECORD_FOUND);
            } else {
                String errMsg = "Data Not Found.";
//                throw new
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
