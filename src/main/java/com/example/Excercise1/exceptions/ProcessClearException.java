package com.example.Excercise1.exceptions;

public class ProcessClearException extends RuntimeException {
    public ProcessClearException(String message) {
        super(message);
    }

    public ProcessClearException(String message, Throwable cause) {
        super(message, cause);
    }
}
