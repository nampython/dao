package com.example.Excercise1.exceptions;

public class SetDataException extends RuntimeException{
    public SetDataException(String message) {
        super(message);
    }

    public SetDataException(String message, Throwable cause) {
        super(message, cause);
    }
}

