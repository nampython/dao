package com.example.Excercise1.repository;

import com.example.Excercise1.valueObject.ValueObject;

import java.util.List;
import java.util.Map;

public interface StoredProcedures {
    void executeProcedure(String storedProcedureName);
    <T extends ValueObject> void executeProcedure(String storedProcedureName, List params);
    Map<Integer, Object> executeProcedure(String procedureName, Map<Integer, Object> inputParams, Map<Integer, Integer> outputParams);
}
