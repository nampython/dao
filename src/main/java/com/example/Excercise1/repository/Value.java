package com.example.Excercise1.repository;

import java.io.Serializable;

//TODO: Complete this class
public class Value implements Serializable {
    private Object value = null;

    public Value(Object obj) {
        value = obj;
    }

    public String toString() {
        if (this.value == null) {
            return null;
        }
        if (value instanceof String) {
            return (String) value;
        }
        return value.toString();
    }
}