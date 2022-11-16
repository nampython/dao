package com.example.Excercise1.utils;

import com.example.Excercise1.valueObject.RequiredError;

import java.util.ArrayList;
import java.util.List;

public class BaseAjaxResponse {
    private String disableSubmit = "";

    private String isODSEnabled = "false";

    private List<RequiredError> requiredErrorList = new ArrayList<>();

    public BaseAjaxResponse(String disableSubmit, String isODSEnabled, List<RequiredError> requiredErrorList) {
        this.disableSubmit = disableSubmit;
        this.isODSEnabled = isODSEnabled;
        this.requiredErrorList = requiredErrorList;
    }

    public void addRequireError(String message) {

        RequiredError requiredError = new RequiredError();
        requiredError.setMessage(message);
        requiredErrorList.add(requiredError);
    }


    public BaseAjaxResponse() {
    }

    public String getDisableSubmit() {
        return disableSubmit;
    }

    public void setDisableSubmit(String disableSubmit) {
        this.disableSubmit = disableSubmit;
    }

    public String getIsODSEnabled() {
        return isODSEnabled;
    }

    public void setIsODSEnabled(String isODSEnabled) {
        this.isODSEnabled = isODSEnabled;
    }

    public List<RequiredError> getRequiredErrorList() {
        return requiredErrorList;
    }

    public void setRequiredErrorList(List<RequiredError> requiredErrorList) {
        this.requiredErrorList = requiredErrorList;
    }
}
