package com.example.Excercise1.valueUtils;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SetValue {
    public abstract void setParamsPreStatement(PreparedStatement statement, Object o, Integer index) throws SQLException;
    public abstract Method setParamsGetMethod(Class<?> cls, Class<?> typeClass, String nameClass) throws NoSuchMethodException;
}
