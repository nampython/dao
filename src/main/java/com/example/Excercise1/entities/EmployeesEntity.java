package com.example.Excercise1.entities;

import com.example.Excercise1.valueObject.ValueObject;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.Excercise1.constants.Database.*;
import static com.example.Excercise1.constants.ResultCode.*;

public class EmployeesEntity implements ValueObject {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private Integer reportsTo;
    private String jobTitle;
    private int resultCode = 101;
    private String resultCodeMessage = null;
    public boolean isDirty;

    public EmployeesEntity() {
    }

    public EmployeesEntity(int employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, Integer reportsTo, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultCodeMessage() {
        return resultCodeMessage;
    }

    public void setResultCodeMessage(String resultCodeMessage) {
        this.resultCodeMessage = resultCodeMessage;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Integer reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesEntity that = (EmployeesEntity) o;
        return employeeNumber == that.employeeNumber && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName) && Objects.equals(extension, that.extension) && Objects.equals(email, that.email) && Objects.equals(officeCode, that.officeCode) && Objects.equals(reportsTo, that.reportsTo) && Objects.equals(jobTitle, that.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle);
    }

    @Override
    public void parseSql(ResultSet var1) throws SQLException {

    }

    @Override
    public void setResultCode(int var1) {

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
    }

    @Override
    public String getExecuteSql() {
        String sql = null;
        switch (this.getResultCode() ) {
            case INSERT_CODE : {
                sql = CUSTOMER_INSERT_SQL;
            }
            case UPDATE_CODE : {
                sql = CUSTOMER_UPDATE_SQL;

            }
            case DELETE_CODE : {
                sql = CUSTOMER_DELETE_SQL;
            }
        }
        return sql;
    }

    @Override
    public List<Object> getParams() {
        return CommonEntities.getParams(this);
    }

    @Override
    public void clear() {
        CommonEntities.processClear(this);
    }

    @Override
    public String getDeleteSql() {
        return EMPLOYEES_DELETE_SQL;
    }

    @Override
    public String getInsertSql() {
        return EMPLOYEES_INSERT_SQL;
    }

    @Override
    public String getUpdateSql() {
        return EMPLOYEES_UPDATE_SQL;
    }

    @Override
    public String getSelectSql() {
        return EMPLOYEES_SELECT_SQL;
    }
}
