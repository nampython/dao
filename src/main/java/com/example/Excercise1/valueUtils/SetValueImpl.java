package com.example.Excercise1.valueUtils;

import com.example.Excercise1.exceptions.SetParameterException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class SetValueImpl implements SetValue {

    @Override
    public void setParamsPreStatement(PreparedStatement statement, Object obj, Integer index) throws SQLException {

        if (obj == null) {
            statement.setString(index, null);
        } else if (obj instanceof String) {
            statement.setString(index, (String) obj);
        } else if (obj instanceof Integer) {
            statement.setInt(index, (Integer) obj);
        } else if (obj instanceof Date) {
            statement.setDate(index, (Date) obj);
        } else if (obj instanceof BigDecimal) {
            statement.setBigDecimal(index, (BigDecimal) obj);
        } else if (obj instanceof Long) {
            statement.setLong(index, (Long) obj);
        } else if (obj instanceof Double) {
            statement.setDouble(index, (Double) obj);
        } else if (obj instanceof Float) {
            statement.setFloat(index, (Float) obj);
        } else if (obj instanceof Short) {
            statement.setFloat(index, (Short) obj);
        } else {
            throw new UnsupportedOperationException("The type " + obj.getClass().getName() + " is currently not supported.");
        }
    }

    @Override
    public Method setParamsGetMethod(Class<?> cls, Class<?> typeClass, String nameClass) throws NoSuchMethodException {
        Method method = null;

        if (String.class.equals(typeClass)) {
            method = cls.getMethod(nameClass, String.class);
        } else if (Integer.class.equals(typeClass)) {
            method = cls.getMethod(nameClass, Integer.class);
        } else if (BigDecimal.class.equals(typeClass)) {
            method = cls.getMethod(nameClass, BigDecimal.class);
        } else if (Short.class.equals(typeClass)) {
            method = cls.getMethod(nameClass, Short.class);
        } else {
            throw new SetParameterException("Error in processing parameters for class " + cls.getSimpleName() + "with method" + nameClass);
        }
        return method;
    }
}
