package com.example.Excercise1.exceptions;

public class ProcessParseSqlException extends RuntimeException {
    public ProcessParseSqlException(String message) {
        super(message);
    }

    public ProcessParseSqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
