package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.GetDataException;
import com.example.Excercise1.valueObject.Value;
import com.example.Excercise1.valueObject.ValueObject;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    <T extends ValueObject> List<T> getListOfValueObject(String sql, Class<T> valueObjectClass) throws GetDataException;
    <T extends ValueObject> T getSingleValueObject(String sql, Class<T> valueObjectClass);
    <T extends ValueObject> List<T> getListOfValueObjectWithPreparedStatement(String sql, List<Object> params, Class<T> valueObjectClass);
    <T extends ValueObject> T getSingleValueObjectWithPreparedStatement(String sql, List<Object> params, Class<T> valueObjectClass) throws GetDataException;
    <T extends ValueObject> List<List<Value>> getMultipleRowsWithStatement(String sql);
    <T extends ValueObject> List<Value> getSingleRow(String sql);
    void setValueObject(ValueObject valueObject) throws SQLException;
    void setListOfValueObjects(List<ValueObject> valueObjects) throws SQLException;
}
