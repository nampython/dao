package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.GetDataException;
import com.example.Excercise1.exceptions.SetDataException;
import com.example.Excercise1.valueObject.Value;
import com.example.Excercise1.valueObject.ValueObject;

import java.util.List;

public interface PreparedStatementDao {
    List<List<Value>> getValueObjects(String sql, List<Object> params) throws GetDataException;
    <T extends ValueObject> List<T> getValueObjects(String sql, List<Object> params, Class<T> valueObjectClass) throws GetDataException;
    <T extends ValueObject> T getSingleValueObject(String sql, List<Object> params, Class<T> valueObjectClass) throws GetDataException;
    void setValueObject(ValueObject valueObject) throws SetDataException;
    void setValueObjects(List<ValueObject> valueObjects) throws SetDataException;
}
