package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.ConnectionException;
import com.example.Excercise1.exceptions.SetParameterException;
import com.example.Excercise1.exceptions.StatementException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import static com.example.Excercise1.constants.MessageException.*;

public class FunctionalCommon {
    // TODO: move these variables to constants file
    public static String URL = "jdbc:mysql://localhost:3306/classicmodels";
    public static String USER = "root";
    public static String PW = "admin";


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
    private static void setParam(PreparedStatement ps, Object obj, int j) throws SQLException {
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
        properties.setProperty("user", USER);
        properties.setProperty("password", PW);
        properties.setProperty("useSSL", "false");
        try {
            return DriverManager.getConnection(URL, properties);
        } catch (SQLException sqlException) {
            throw new ConnectionException(FAILED_TO_GET_CONNECTION, sqlException.getCause());
        }
    }
}
