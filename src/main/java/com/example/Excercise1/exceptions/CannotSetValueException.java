package com.example.Excercise1.exceptions;

public class CannotSetValueException extends RuntimeException{
    public CannotSetValueException(String message) {
        super(message);
    }

    public CannotSetValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
