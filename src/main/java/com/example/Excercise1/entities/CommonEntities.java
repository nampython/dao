package com.example.Excercise1.entities;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static com.example.Excercise1.constants.Database.*;
import static com.example.Excercise1.constants.ResultCode.*;

public class CommonEntities {
    public static final String RESULT_CODE = "resultCode";
    public static final String RESULT_CODE_MESSAGE = "resultCodeMessage";
    public static final String IS_DIRTY = "isDirty";
    public static final String LOG = "log";

    public static String getExecuteSql(int resultCode) {
        String sql = null;
        switch (resultCode) {
            case INSERT_CODE: {
                sql = CUSTOMER_INSERT_SQL;
            }
            case UPDATE_CODE: {
                sql = CUSTOMER_UPDATE_SQL;

            }
            case DELETE_CODE: {
                sql = CUSTOMER_DELETE_SQL;
            }
        }
        return sql;
    }

    /**
     *
     * @param o
     * @return
     */
    public static List<Object> getParams(Object o) {
        Class<?> cls = o.getClass();
        Method method = null;
        String[] listNameOfInstanceVariable = null;
        String nameOfInstanceVariable = null;
        List<Object> params = new ArrayList<>();

        for (Field field : cls.getDeclaredFields()) {
            listNameOfInstanceVariable = field
                    .toString()
                    .split("\\.");
            nameOfInstanceVariable = listNameOfInstanceVariable[listNameOfInstanceVariable.length - 1];
            if (Objects.equals(nameOfInstanceVariable, RESULT_CODE) ||
                    Objects.equals(nameOfInstanceVariable, RESULT_CODE_MESSAGE) ||
                    Objects.equals(nameOfInstanceVariable, IS_DIRTY) ||
                    Objects.equals(nameOfInstanceVariable, LOG)) {
            } else {
                try {
                    method = cls.getMethod("get" + nameOfInstanceVariable.substring(0, 1).toUpperCase() + nameOfInstanceVariable.substring(1));
                    params.add(method.invoke(o));
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return params;
    }

    /**
     *
     * @param o
     * @param rs
     */
    public static void processesParseSql(Object o, ResultSet rs) {
        Class<?> cls = o.getClass();
        String[] listNameOfInstanceVariable = null;
        String nameOfInstanceVariable = null;
        Method method = null;
        for (Field field : cls.getDeclaredFields()) {
            Class<?> type = field.getType();
            listNameOfInstanceVariable = field
                    .toString()
                    .split("\\.");
            nameOfInstanceVariable = listNameOfInstanceVariable[listNameOfInstanceVariable.length - 1];
            if (Objects.equals(nameOfInstanceVariable, RESULT_CODE) ||
                    Objects.equals(nameOfInstanceVariable, RESULT_CODE_MESSAGE) ||
                    Objects.equals(nameOfInstanceVariable, IS_DIRTY) ||
                    Objects.equals(nameOfInstanceVariable, LOG)) {
            } else {
                try {
                    method = cls.getMethod("set" + nameOfInstanceVariable.substring(0, 1).toUpperCase() + nameOfInstanceVariable.substring(1), type);
                    invokeMethod(o, method, rs, type, nameOfInstanceVariable);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void invokeMethod(Object o, Method method, ResultSet rs, Class<?> field, String nameField) throws SQLException, InvocationTargetException, IllegalAccessException {
        if (int.class.equals(field)) {
            method.invoke(o, rs.getInt(nameField));
        } else if (String.class.equals(field)) {
            method.invoke(o, rs.getString(nameField));
        }
    }

    public static void processClear(Object o) {
        Class<?> cls = o.getClass();
        Method method = null;
        String[] listNameOfInstanceVariable = null;
        String nameOfInstanceVariable = null;
        for (Field field : cls.getDeclaredFields()) {
            Class<?> type = field.getType();
            listNameOfInstanceVariable = field
                    .toString()
                    .split("\\.");
            nameOfInstanceVariable = listNameOfInstanceVariable[listNameOfInstanceVariable.length - 1];
            if (Objects.equals(nameOfInstanceVariable, RESULT_CODE) ||
                    Objects.equals(nameOfInstanceVariable, RESULT_CODE_MESSAGE) ||
                    Objects.equals(nameOfInstanceVariable, IS_DIRTY) ||
                    Objects.equals(nameOfInstanceVariable, LOG)) {
            } else {
                try {
                    method = cls.getMethod("set" + nameOfInstanceVariable.substring(0, 1).toUpperCase() + nameOfInstanceVariable.substring(1), type);
                    invokeMethodClear(o, method, type);
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void invokeMethodClear(Object o, Method method, Class<?> type) throws InvocationTargetException, IllegalAccessException {
        if (int.class.equals(type)) {
            method.invoke(o, 0);
        } else if (String.class.equals(type)) {
            method.invoke(o, (Object) null);
        } else if (BigDecimal.class.equals(type)) {
            method.invoke(o, BigDecimal.valueOf(0));
        }
    }
}