package com.example.Excercise1.constants;

public class MessageException {
    public static final String FAILED_TO_GET_DATA = "Failed to get data with sql query: %s, Value Object: %s";
    public static final String FAILED_TO_GET_MULTIPLE_ROW = "Failed to get multiple row with sql query: %s";
    public static final String FAILED_TO_GET_SINGLE_ROW = "Failed to get single row with sql query: %s";
    public static final String FAILED_TO_GET_CONNECTION = "Failed to get connection to database schema: %s";
    public static final String FAILED_TO_CLOSE_CONNECTION = "Failed to close connection to database";
    public static final String FAILED_TO_CLOSE_STATEMENT = "Failed to close the statement";
    public static final String INVALID_PARAMETER = "Invalid parameters: params is NULL";
    public static final String FAILED_TO_SET_PARAMETER = "Failed to set parameter for PreparedStatement with params: %s";
    public static final String FAILED_TO_SAVE_VALUE_OBJECT = "Failed to save data into the database with Value Object: %s";
    public static final String FAILED_TO_EXECUTE = "Failure to  executeSQL with sql: %s and params: %s";
    public static final String FAILED_TO_LOAD_VALUE_OBJECTS_BY_STORED_PRODUCER = "Failed to execute stored procedures: %s";
    public static final String FAILED_TO_LOAD_VALUE_OBJECTS_BY_STORED_PRODUCER_WITH_INPUT_PARAMS = "Failed to execute stored procedures: " + "%s" + " with  params: " + "%s";
    public static final String FAILED_TO_LOAD_VALUE_OBJECT_BY_PRODUCER_INPUT_AND_OUTPUT_PARAMS = "Failed to execute stored procedures " + "%s" + " InputParams: " + "%s" + " OutParams: " + "%s";
}