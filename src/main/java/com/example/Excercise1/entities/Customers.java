package com.example.Excercise1.entities;

import com.example.Excercise1.persistence.CommonEntities;
import com.example.Excercise1.persistence.ProcessDatabase;
import com.example.Excercise1.valueObject.ValueObject;
import lombok.*;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

import static com.example.Excercise1.constants.ResultCode.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Customers implements ValueObject {
    private Integer customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Integer salesRepEmployeeNumber;
    private BigDecimal creditLimit;
    private int resultCode = 101;
    private String resultCodeMessage = null;
    public boolean isDirty;

    public Customers(int customerNumber, String customerName, String contactLastName, String contactFirstName, String phone, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, Integer salesRepEmployeeNumber, BigDecimal creditLimit) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.creditLimit = creditLimit;
    }

    @Override
    public void clear() {
        CommonEntities.processClear(this);
    }

    @Override
    public void parseSql(ResultSet rs) {
        this.clear();
        CommonEntities.processesParseSql(this, rs);
    }

    @Override
    public void setResultCode(int rc) {
        this.resultCode = rc;
    }

    /**
     * Use to identify the sql query of the entity based on the result-code
     * INSERT_CODE = 101
     * UPDATE_CODE = 0
     * DELETE_CODE = 103
     *
     * @return sql query based on result code
     */
    @Override
    public String getExecuteSql() {
        String sqlQuery = null;

        switch (this.resultCode) {
            case INSERT_CODE: {
                sqlQuery = ProcessDatabase.generatedSqlQuery().get("customers").get(3);
                break;
            }
            case UPDATE_CODE: {
                sqlQuery = ProcessDatabase.generatedSqlQuery().get("customers").get(2);
                break;
            }
            case DELETE_CODE: {
                sqlQuery = ProcessDatabase.generatedSqlQuery().get("customers").get(1);
                break;
            }
        }
        return sqlQuery;
    }
    @Override
    public List<Object> getParams() {
        return CommonEntities.getParams(this, this.resultCode);
    }

    @Override
    public String getSelectSql() {
        return ProcessDatabase.generatedSqlQuery().get("customers").get(0);
    }

    @Override
    public String getDeleteSql() {
        return ProcessDatabase.generatedSqlQuery().get("customers").get(1);
    }

    @Override
    public String getUpdateSql() {
        return ProcessDatabase.generatedSqlQuery().get("customers").get(2);
    }

    @Override
    public String getInsertSql() {
        return ProcessDatabase.generatedSqlQuery().get("customers").get(3);
    }

    @Override
    public boolean isModified() {
        return this.isDirty;
    }

    @Override
    public  int getResultCode() {
        return this.resultCode;
    }
}
