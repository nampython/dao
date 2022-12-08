package com.example.Excercise1.persistence;

import com.example.Excercise1.exceptions.GetParamsException;
import com.example.Excercise1.exceptions.ProcessClearException;
import com.example.Excercise1.exceptions.ProcessParseSqlException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.example.Excercise1.persistence.ProcessDatabase.*;
import static com.example.Excercise1.constants.ResultCode.*;

public class CommonEntities {
    public static final String RESULT_CODE_VARIABLE = "resultCode";
    public static final String RESULT_CODE_MESSAGE_VARIABLE = "resultCodeMessage";
    public static final String IS_DIRTY_VARIABLE = "isDirty";
    public static final String LOG = "log";

    /**
     * Use to identify the sql query of the entity based on the result-code
     * INSERT_CODE = 1
     * UPDATE_CODE = 101
     * DELETE_CODE = 103
     *
     * @param resultCode result-code
     * @return sql query based on result code
     */
    public static String getExecuteSql(int resultCode) {
        String sqlQuery = null;
        // TODO: this para is wrong
        switch (resultCode) {
            case INSERT_CODE: {
                sqlQuery = CUSTOMER_INSERT_SQL;
            }
            case UPDATE_CODE: {
                sqlQuery = CUSTOMER_UPDATE_SQL;

            }
            case DELETE_CODE: {
                sqlQuery = CUSTOMER_DELETE_SQL;
            }
        }
        return sqlQuery;
    }

    public static boolean checkInstanceVariable(String instanceVariable) {
        final boolean isResultCode = Objects.equals(instanceVariable, RESULT_CODE_VARIABLE);
        final boolean isResultCodeMessage = Objects.equals(instanceVariable, RESULT_CODE_MESSAGE_VARIABLE);
        final boolean isDirty = Objects.equals(instanceVariable, IS_DIRTY_VARIABLE);
        final boolean isLog = Objects.equals(instanceVariable, LOG);
        return isResultCode || isResultCodeMessage || isDirty || isLog;
    }
    /**
     * Use to get list of parameters in the object
     *
     * @param o object of the class
     * @return List of objects
     */
    public static List<Object> getParams(Object o) {
        Class<?> cls = o.getClass();
        Method method = null;
        String[] listOfInstanceVariable = null;
        String instanceVariable = null;
        List<Object> params = new ArrayList<>();

        try {
            for (Field field : cls.getDeclaredFields()) {
                listOfInstanceVariable = field
                        .toString()
                        .split("\\.");
                instanceVariable = listOfInstanceVariable[listOfInstanceVariable.length - 1];

                if (checkInstanceVariable(instanceVariable)) {

                } else {
                    method = cls.getMethod("get" + instanceVariable.substring(0, 1).toUpperCase() + instanceVariable.substring(1));
                    params.add(method.invoke(o));
                }
            }
            return params;
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new GetParamsException("Failed to get parameters of object.");
        }
    }

    /**
     * Use to get value after receiving result from Resultset
     *
     * @param o  object
     * @param rs resultset
     */
    public static void processesParseSql(Object o, ResultSet rs) {
        Class<?> cls = o.getClass();
        String[] listOfInstanceVariable = null;
        String instanceVariable = null;
        Method method = null;

        try {
            for (Field field : cls.getDeclaredFields()) {
                listOfInstanceVariable = field
                        .toString()
                        .split("\\.");
                instanceVariable = listOfInstanceVariable[listOfInstanceVariable.length - 1];
                if (checkInstanceVariable(instanceVariable)) {
                } else {
                    final Class<?> type = field.getType();
                    method = cls.getMethod("set" + instanceVariable.substring(0, 1).toUpperCase() + instanceVariable.substring(1), type);
                    invokeMethod(o, method, rs, type, instanceVariable);
                }
            }
        } catch (SQLException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new ProcessParseSqlException("Failed to get value  after processing Resultset");
        }

    }

    private static void invokeMethod(Object o, Method method, ResultSet rs, Class<?> typeField, String nameField) throws SQLException, InvocationTargetException, IllegalAccessException {
        if (int.class.equals(typeField)) {
            method.invoke(o, rs.getInt(nameField));
        } else if (String.class.equals(typeField)) {
            method.invoke(o, rs.getString(nameField));
        } else if (float.class.equals(typeField)) {
            method.invoke(o, rs.getFloat(nameField));
        } else if (boolean.class.equals(typeField)) {
            method.invoke(o, rs.getBoolean(nameField));
        } else if (BigDecimal.class.equals(typeField)) {
            method.invoke(o, rs.getBigDecimal(nameField));
        } else if (long.class.equals(typeField)) {
            method.invoke(o, rs.getLong(nameField));
        } else if (Date.class.equals(typeField)) {
            method.invoke(o, rs.getDate(nameField));
        } else if (double.class.equals(typeField)) {
            method.invoke(o, rs.getDouble(nameField));
        }
    }

    /**
     * User to clear value of instance variables
     *
     * @param o Object
     */
    public static void processClear(Object o) {
        Class<?> cls = o.getClass();
        Method method = null;
        String[] listOfInstanceVariable = null;
        String instanceVariable = null;
        try {
            for (Field field : cls.getDeclaredFields()) {
                Class<?> type = field.getType();
                listOfInstanceVariable = field
                        .toString()
                        .split("\\.");
                instanceVariable = listOfInstanceVariable[listOfInstanceVariable.length - 1];
                if (checkInstanceVariable(instanceVariable)) {
                } else {
                    method = cls.getMethod("set" + instanceVariable.substring(0, 1).toUpperCase() + instanceVariable.substring(1), type);
                    invokeMethodClear(o, method, type);
                }
            }
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new ProcessClearException("Failed to clear instance variables");
        }

    }

    private static void invokeMethodClear(Object o, Method method, Class<?> type) throws InvocationTargetException, IllegalAccessException {
        if (int.class.equals(type)) {
            method.invoke(o, 0);
        } else if (String.class.equals(type)) {
            method.invoke(o, (Object) null);
        } else if (BigDecimal.class.equals(type)) {
            method.invoke(o, BigDecimal.valueOf(0));
        }
    }
}