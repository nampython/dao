package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.XifinDataNotFoundException;
import com.example.Excercise1.mars.ValueObject;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    <T extends ValueObject> List<T> getValueObject(String sql, Class<T> valueObjectClass) throws XifinDataNotFoundException;

    <T extends ValueObject> T getValueObject(String sql, List params, Class<T> valueObjectClass) throws XifinDataNotFoundException;

    <T extends ValueObject> List<T> getValueObjects(String sql, List params, Class<T> valueObjectClass);

    <T extends ValueObject> List<List<Value>> getMultipleRows(String sql, List params);
    <T extends ValueObject> List<Value> getSingleRow(String sql, List params);
    void setValueObject(ValueObject valueObject) throws SQLException;

    void setValueObjects(List<ValueObject> valueObjects) throws SQLException;
    int getMaxId(String sql) throws SQLException;
}
