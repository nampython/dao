package com.example.Excercise1.constants;

public class MessageException {
    public static final String FAILED_TO_GET_DATA = "Failed to get data";
    public static final String FAILED_TO_GET_MULTIPLE_ROW = "Failed to get multiple row";
    public static final String FAILED_TO_GET_SINGLE_ROW = "Failed to get single row";
    public static final String FAILED_TO_GET_CONNECTION = "Failed to get connection to database";
    public static final String FAILED_TO_CLOSE_CONNECTION = "Failed to close connection to database";
    public static final String FAILED_TO_CLOSE_STATEMENT = "Failed to close the statement";
    public static final String INVALID_PARAMETER = "Invalid parameters: params is NULL";
    public static final String FAILED_TO_SET_PARAMETER = "Failed to set parameter for PreparedStatement";
    public static final String FAILED_TO_SAVE_VALUE_OBJECT = "Failed to save data into the database";
    public static final String FAILED_TO_LOAD_VALUE_OBJECT_BY_PRODUCER = "Failed to execute procedure: " + "%s" + " with  params: " + "%s";
    public static final String FAILED_TO_LOAD_VALUE_OBJECT_BY_PRODUCER_INPUT_AND_OUTPUT_PARAMS = "Failed to execute procedure " + "%s" + " InputParams: " + "%s" + " OutParams: " + "%s";
}