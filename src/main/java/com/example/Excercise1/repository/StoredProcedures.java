package com.example.Excercise1.repository;

import com.example.Excercise1.valueObject.Value;
import com.example.Excercise1.valueObject.ValueObject;

import java.util.List;
import java.util.Map;

public interface StoredProcedures {
    List<List<Value>> executeProcedure(String storedProcedureName);
    <T extends ValueObject> List<List<Value>> executeProcedureWithInputParams(String storedProcedureName, List<Object> params);
    Map<Integer, Object> executeProcedureWithInputAndOutputParams(String procedureName, Map<Integer, Object> inputParams, Map<Integer, Integer> outputParams);
}
