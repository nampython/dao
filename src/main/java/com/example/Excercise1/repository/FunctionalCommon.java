package com.example.Excercise1.repository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class FunctionalCommon {

    public static String URL = "jdbc:mysql://localhost:3306/classicmodels";
    public static String USER = "root";
    public static String PW = "admin";

    /**
     * @param ps
     * @param params
     */
    public static void setSearchParams(PreparedStatement ps, List params) throws SQLException {
        // TODO - Complete this fucntion
        if (params == null) {
            throw new NullPointerException("Invalid parameters: params is NULL");
        }

        for (int i = 0, j = 1; i < params.size(); i++, j++) {
            Object obj = params.get(i);
//            ps.setString(1, (String) obj);
            setParam(ps, obj, j);
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
            //
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
        // TODO - Complete this fucntion
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException sqle) {
            // nothing
        } finally {
            connection = null;
        }
    }

    public static void closeStatement(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException sqle) {
            // nothing
        } finally {
            stmt = null;
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PW);
    }
}
