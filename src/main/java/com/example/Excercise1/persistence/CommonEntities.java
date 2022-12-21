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

import static com.example.Excercise1.constants.ResultCode.*;

public class CommonEntities {
    public static final String RESULT_CODE_VARIABLE = "resultCode";
    public static final String RESULT_CODE_MESSAGE_VARIABLE = "resultCodeMessage";
    public static final String IS_DIRTY_VARIABLE = "isDirty";
    public static final String LOG = "log";

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
    public static List<Object> getParams(Object o, int resultCode) {
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
                    String getValue = "get" + instanceVariable.substring(0, 1).toUpperCase() + instanceVariable.substring(1);
                    if (resultCode == DELETE_CODE) {
                        method = cls.getMethod(getValue);
                        params.add(method.invoke(o));
                        return params;
                    } else {
                        method = cls.getMethod(getValue);
                        params.add(method.invoke(o));
                    }

                }
            }
//            [1,2, 3, 23, 2, 2,1]
            // change position ele when using sql query
            if (resultCode == UPDATE_CODE) {
                List<Object>  newParams = new ArrayList<>();
                for (int i = 1; i < params.size(); i++) {
                    newParams.add(params.get(i));
                }
                newParams.add(params.get(0));
                return newParams;
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