package com.example.Excercise1.utils;

import com.example.Excercise1.exceptions.CannotSetValueException;
import com.example.Excercise1.exceptions.SetParameterException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface LogicEntity {
    public <T> void setValue(Object o1, Object o2, List<T> objects) throws CannotSetValueException, SetParameterException;
}

