package com.example.Excercise1.utils;

public class ErrorCodeMap {
    /**
     * Generic 'success' code. (0 - 199)
     */
    public static final int SUCCESS = 100;
    public static final String SUCCESS_MSG = "Successful";

    public static final int NEW_RECORD = 101;
    public static final String NEW_RECORD_MSG = "New Record";

    public static final int UPDATED_RECORD = 102;
    public static final String UPDATED_RECORD_MSG = "Updated Record";

    public static final int DELETED_RECORD = 103;
    public static final String DELETED_RECORD_MSG = "Deleted Record";

    public static final int TRANSITION = 104;

    public static final int DELETED_NEW_RECORD = 105;
    public static final String DELETED_NEW_RECORD_MSG = "Deleted New Record";

    public static final int DAO_INIT = 106;
    public static final String DAO_INIT_MSG = "DAO Initialization";

    public static final int RECORD_FOUND = 0;
    public static final String RECORD_FOUND_MSG = "Select Successful";

    public static final int RECORD_NOT_FOUND = 3;
    public static final String RECORD_NOT_FOUND_MSG = "Select Unsuccessful";

    public static final int DATA_LOCKED = 4;
    public static final String DATA_LOCKED_MSG = "Data locked";
}
