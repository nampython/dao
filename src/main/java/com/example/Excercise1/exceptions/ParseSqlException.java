package com.example.Excercise1.exceptions;

public class ParseSqlException extends RuntimeException{
    public ParseSqlException(String message) {
        super(message);
    }

    public ParseSqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
