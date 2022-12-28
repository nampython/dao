package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.GetDataException;
import com.example.Excercise1.valueObject.Value;
import com.example.Excercise1.valueObject.ValueObject;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    <T extends ValueObject> List<T> getValueObjects(String sql, Class<T> valueObjectClass) throws GetDataException;
    <T extends ValueObject> T getSingleValueObject(String sql, Class<T> valueObjectClass) throws GetDataException;
    <T extends ValueObject> List<List<Value>> getMultipleRows(String sql)  throws GetDataException;;
    <T extends ValueObject> List<Value> getSingleRow(String sql) throws GetDataException;;
}
