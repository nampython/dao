package com.example.Excercise1.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface LogicEntity {
    public <T> void setValue(Object o1, Object o2, List<T> objects) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException;

}

