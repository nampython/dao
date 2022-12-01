package com.example.Excercise1.exceptions;

public class GetParamsException extends RuntimeException {
    public GetParamsException(String message) {
        super(message);
    }

    public GetParamsException(String message, Throwable cause) {
        super(message, cause);
    }
}
