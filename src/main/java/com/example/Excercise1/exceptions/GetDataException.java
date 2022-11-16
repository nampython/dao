package com.example.Excercise1.exceptions;

public class GetDataException extends RuntimeException{
    public GetDataException(String message) {
        super(message);
    }

    public GetDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
