package com.example.Excercise1.exceptions;

public class SetParameterException extends RuntimeException{
    public SetParameterException(String message) {
        super(message);
    }

    public SetParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
