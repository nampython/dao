package com.example.Excercise1.repository;

import com.example.Excercise1.enviroments.EnvironmentConfiguration;
import com.example.Excercise1.exceptions.ConnectionException;
import com.example.Excercise1.exceptions.SetParameterException;
import com.example.Excercise1.exceptions.StatementException;
import com.example.Excercise1.valueObject.Value;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.example.Excercise1.constants.MessageException.*;

public class FunctionalCommon {
    /**
     * @param ps
     * @param params
     */
    public static void setSearchParams(PreparedStatement ps, List<Object> params) {
        // TODO - Complete this function
        if (params == null) {
            throw new NullPointerException(INVALID_PARAMETER);
        }
        try {
            for (int i = 0, j = 1; i < params.size(); i++, j++) {
                Object obj = params.get(i);
                setParam(ps, obj, j);
            }
        } catch (SQLException | UnsupportedOperationException  sqlException) {
            throw new SetParameterException(FAILED_TO_SET_PARAMETER);
        }
    }

    /**
     * @param ps
     * @param j
     * @param obj
     */
    public static void setParam(PreparedStatement ps, Object obj, int j) throws SQLException {
        // TODO - Complete this function
        if (obj == null) {
            ps.setString(j, null);
        } else if (obj instanceof String) {
            ps.setString(j, (String) obj);
        } else if (obj instanceof Integer) {
            ps.setInt(j, (Integer) obj);
        } else if (obj instanceof Date) {
            ps.setDate(j, (Date) obj);
        } else if (obj instanceof BigDecimal) {
            ps.setBigDecimal(j, (BigDecimal) obj);
        } else if (obj instanceof Long) {
            ps.setLong(j, (Long) obj);
        } else if (obj instanceof Double) {
            ps.setDouble(j, (Double) obj);
        } else if (obj instanceof Float) {
            ps.setFloat(j, (Float) obj);
        } else if (obj instanceof Short) {
            ps.setFloat(j, (Short) obj);
        }
        else {
            throw new UnsupportedOperationException("The type " + obj.getClass().getName() + " is currently not supported.");
        }
    }

    /**
     * @param sql
     * @param params
     */
    private void processParams(String sql, List params) {
        // TODO - Complete this function
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlException) {
            throw new ConnectionException(FAILED_TO_CLOSE_CONNECTION, sqlException.getCause());
        }
    }

    public static void closeStatement(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqlException) {
            throw new StatementException(FAILED_TO_CLOSE_STATEMENT, sqlException.getCause());
        }
    }

    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", EnvironmentConfiguration.properties().getProperty("jdbc.user"));
        properties.setProperty("password", EnvironmentConfiguration.properties().getProperty("jdbc.password"));
        properties.setProperty("useSSL", "false");
        try {
            return DriverManager.getConnection(EnvironmentConfiguration.properties().getProperty("jdbc.url"), properties);
        } catch (SQLException sqlException) {
            throw new ConnectionException(FAILED_TO_GET_CONNECTION, sqlException.getCause());
        }
    }

    public static void getMultipleRows(ResultSet rs, List<List<Value>> values) throws SQLException {
        ResultSetMetaData metaData;
        int columnCount;
        while (rs.next()) {
            metaData = rs.getMetaData();
            columnCount = metaData.getColumnCount();
            if (columnCount <= 0) {
                continue;
            }
            List<Value> row = new ArrayList<>();
            for (int j = 1; j <= columnCount; j++) {
                Object o = rs.getObject(j);
                row.add(new Value(o));
            }
            values.add(row);
        }
    }
}
