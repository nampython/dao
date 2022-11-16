package com.example.Excercise1.exceptions;

public class ProcedureException extends RuntimeException{
    public ProcedureException(String message) {
        super(message);
    }

    public ProcedureException(String message, Throwable cause) {
        super(message, cause);
    }
}
