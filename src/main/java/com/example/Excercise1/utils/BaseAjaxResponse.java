package com.example.Excercise1.utils;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BaseAjaxResponse {
    private String disableSubmit = "";
    private String isODSEnabled = "false";
    private List<InfoMessage> infoMessageList = new ArrayList<>();
    private List<RequiredError> requiredErrorList = new ArrayList<>();

    public void addRequiredError(String msg) {
        RequiredError requiredError = new RequiredError();
        requiredError.setMessage(msg);
        this.requiredErrorList.add(requiredError);
    }
    public void addRequiredError(int errorCode, String msg) {
        RequiredError requiredError = new RequiredError();
        requiredError.setErrorCode(String.valueOf(errorCode));
        requiredError.setMessage(msg);
    }
}
