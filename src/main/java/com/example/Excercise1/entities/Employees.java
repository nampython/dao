package com.example.Excercise1.entities;

import com.example.Excercise1.persistence.CommonEntities;
import com.example.Excercise1.persistence.Database;
import com.example.Excercise1.valueObject.ValueObject;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Employees implements ValueObject {
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

    public Employees(int employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, Integer reportsTo, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    @Override
    public void clear() {
        CommonEntities.processClear(this);
    }

    @Override
    public void parseSql(ResultSet rs) throws SQLException {
        this.clear();
        CommonEntities.processesParseSql(this, rs);
    }

    @Override
    public void setResultCode(int var1) {

    }

    @Override
    public String getExecuteSql() {
        return CommonEntities.getExecuteSql(this.getResultCode());
    }

    @Override
    public List<Object> getParams() {
        return CommonEntities.getParams(this);
    }


    @Override
    public String getSelectSql() {
        return Database.generatedSqlQuery().get("employees").get(0);
    }

    @Override
    public String getDeleteSql() {
        return Database.generatedSqlQuery().get("employees").get(1);
    }

    @Override
    public String getUpdateSql() {
        return Database.generatedSqlQuery().get("employees").get(2);
    }

    @Override
    public String getInsertSql() {
        return Database.generatedSqlQuery().get("employees").get(3);
    }
}
