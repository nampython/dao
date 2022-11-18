package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.ProcedureException;
import com.example.Excercise1.valueObject.Value;
import com.example.Excercise1.valueObject.ValueObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.example.Excercise1.constants.MessageException.FAILED_TO_LOAD_VALUE_OBJECT_BY_PRODUCER;
import static com.example.Excercise1.constants.MessageException.FAILED_TO_LOAD_VALUE_OBJECT_BY_PRODUCER_INPUT_AND_OUTPUT_PARAMS;
import static com.example.Excercise1.repository.FunctionalCommon.*;
import static com.example.Excercise1.repository.FunctionalCommon.getMultipleRows;

public class StoredProceduresImpl implements StoredProcedures {
    private static final Logger log = LogManager.getLogger(StoredProceduresImpl.class);

    /**
     * @param storedProcedureName
     */
    @Override
    public List<List<Value>> executeProcedure(String storedProcedureName) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSetMetaData metaData = null;
        ResultSet rs = null;
        List<List<Value>> values = new ArrayList<>();
        try {
            log.info("message=Calling Stored Procedure= " + storedProcedureName);
            connection = getConnection();
            callableStatement = connection.prepareCall(storedProcedureName);
            callableStatement.execute();
            rs = callableStatement.getResultSet();
            getMultipleRows(rs, values);
            return values;
        } catch (SQLException e) {
            throw new ProcedureException(FAILED_TO_LOAD_VALUE_OBJECT_BY_PRODUCER);
        } finally {
            closeStatement(callableStatement);
            closeConnection(connection);
        }
    }

    /**
     * @param storedProcedureName
     * @param params
     * @param <T>
     */
    @Override
    public <T extends ValueObject> List<List<Value>> executeProcedureWithInputParams(String storedProcedureName, List<Object> params) {
        List<List<Value>> values = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        String procSql = processSql(storedProcedureName, params.size());
        try {
            log.debug("message=Calling Stored Procedure= " + storedProcedureName + " ,Argument= " + params);
            connection = getConnection();
            callableStatement = connection.prepareCall(procSql);
            setSearchParams(callableStatement, params);
            callableStatement.execute();
            rs = callableStatement.getResultSet();
            getMultipleRows(rs, values);
            return values;
        } catch (SQLException e) {
            throw new ProcedureException(String.format(FAILED_TO_LOAD_VALUE_OBJECT_BY_PRODUCER, storedProcedureName, params));
        } finally {
            closeStatement(callableStatement);
            closeConnection(connection);
        }
    }

    /**
     *
     *
     * @param:
     * @param inputParams:
     * @param outputParams:
     * @return:
     */
    @Override
    public Map<Integer, Object> executeProcedureWithInputAndOutputParams(String storedProcedureName, Map<Integer, Object> inputParams, Map<Integer, Integer> outputParams) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        Map<Integer, Object> outputData = new HashMap<>();
        int size = inputParams.size() + outputParams.size();
        String procSql = processSql(storedProcedureName, size);
        try {
            log.info("Calling Stored Procedure: " + storedProcedureName + " InputParams: " + inputParams + " OutParams: " + outputParams);
            connection = getConnection();
            callableStatement = connection.prepareCall(procSql);
            //Register output params
            for (Map.Entry<Integer, Integer> entry : outputParams.entrySet()) {
                callableStatement.registerOutParameter(entry.getKey(), entry.getValue());
            }
            //Set input params
            for (Map.Entry<Integer, Object> entry : inputParams.entrySet()) {
                setParam(callableStatement, entry.getValue(), entry.getKey());
            }
            //Execute store procedure
            callableStatement.execute();
            //Get data returned
            for (Integer key : outputParams.keySet()) {
                outputData.put(key, callableStatement.getObject(key));
            }
            return outputData;
        } catch (SQLException e) {
            throw new ProcedureException(String.format(FAILED_TO_LOAD_VALUE_OBJECT_BY_PRODUCER_INPUT_AND_OUTPUT_PARAMS, storedProcedureName, inputParams,outputParams));
        }
    }

    private String processSql(String storedProcedureName, int size) {
        StringBuilder processSql = new StringBuilder("call " + storedProcedureName + "(");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                processSql.append("?");
            } else {
                processSql.append("?, ");
            }
        }
        return processSql.toString() + ")";
    }
}
