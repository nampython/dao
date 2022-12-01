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
public class Offices implements ValueObject {
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;
    private int resultCode = 101;
    private String resultCodeMessage = null;
    public boolean isDirty;

    public Offices(String officeCode, String city, String phone, String addressLine1, String addressLine2, String state, String country, String postalCode, String territory) {
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.territory = territory;
    }

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
        return Database.generatedSqlQuery().get("offices").get(0);
    }

    @Override
    public String getDeleteSql() {
        return Database.generatedSqlQuery().get("offices").get(1);
    }

    @Override
    public String getUpdateSql() {
        return Database.generatedSqlQuery().get("offices").get(2);
    }

    @Override
    public String getInsertSql() {
        return Database.generatedSqlQuery().get("offices").get(3);
    }
}
