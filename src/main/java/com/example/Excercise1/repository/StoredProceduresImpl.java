package com.example.Excercise1.repository;

import com.example.Excercise1.valueObject.ValueObject;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class StoredProceduresImpl implements StoredProcedures{

    /**
     *
     * @param storedProcedureName
     */
    @Override
    public void executeProcedure(String storedProcedureName) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        try {
            connection = FunctionalCommon.getConnection();
            callableStatement = connection.prepareCall(storedProcedureName);
            callableStatement.execute();
            rs = callableStatement.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString(1) + "-" + rs.getString(2) + "-" + rs.getString(3) + rs.getString(4));
            }
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        } finally {
            FunctionalCommon.closeStatement(callableStatement);
            FunctionalCommon.closeConnection(connection);
        }

    }

    /**
     * input: getOfficeByCountry, 'USA'
     * output: call getOfficeByCountry(?, ? ...)
     *
     * @param storedProcedureName
     * @param params
     * @param <T>
     */
    @Override
    public <T extends ValueObject> void executeProcedure(String storedProcedureName, List params) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        String procSql = processSql(storedProcedureName, params);
        try {
            connection = FunctionalCommon.getConnection();
            callableStatement = connection.prepareCall(procSql);
            FunctionalCommon.setSearchParams(callableStatement, params);
            callableStatement.execute();
            rs = callableStatement.getResultSet();
            while (rs.next()) {
                System.out.print(rs.getString(1) + rs.getString(2));
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            FunctionalCommon.closeStatement(callableStatement);
            FunctionalCommon.closeConnection(connection);
        }
    }

    /**
     * input: GetOrderCountByStatus
     * CancelledL: ?
     * total: ?
     * @param procedureName
     * @param inputParams
     * @param outputParams
     * @return
     */
    @Override
    public Map<Integer, Object> executeProcedure(String procedureName, Map<Integer, Object> inputParams, Map<Integer, Integer> outputParams) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        try {
            connection = FunctionalCommon.getConnection();
            callableStatement = connection.prepareCall(procedureName);
            callableStatement.setString(1, "Cancelled");
            callableStatement.registerOutParameter(2, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(2));
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private String processSql(String storedProcedureName, List params) {
        StringBuilder processSql = new StringBuilder("call " + storedProcedureName + "(");
        for (int i = 0; i < params.size(); i++) {
            if (i == params.size() - 1) {
                processSql.append("?");
            } else {
                processSql.append("?, ");
            }
        }
        return processSql.toString() + ")";
    }
}
