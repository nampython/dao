package com.example.Excercise1.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequiredError {
    private String abbrev = "";
    private String errorCode = "";
    private String fieldName ="";
    private String message = "";
}
