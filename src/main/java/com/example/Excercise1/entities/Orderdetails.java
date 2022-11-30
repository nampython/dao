package com.example.Excercise1.entities;

import com.example.Excercise1.persistence.CommonEntities;
import com.example.Excercise1.persistence.Database;
import com.example.Excercise1.valueObject.ValueObject;
import lombok.*;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Orderdetails implements ValueObject {
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private BigDecimal priceEach;
    private short orderLineNumber;

    private int resultCode = 101;

    private String resultCodeMessage = null;

    public boolean isDirty;

    public Orderdetails(int orderNumber, String productCode, int quantityOrdered, BigDecimal priceEach, short orderLineNumber) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public void parseSql(ResultSet rs) throws SQLException {
        this.clear();
        CommonEntities.processesParseSql(this, rs);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return null;
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
    public void clear() {
        CommonEntities.processClear(this);
    }

    @Override
    public String getSelectSql() {
        return Database.generatedSqlQuery().get("orderdetails").get(1);
    }

    @Override
    public String getDeleteSql() {
        return Database.generatedSqlQuery().get("orderdetails").get(2);
    }

    @Override
    public String getUpdateSql() {
        return Database.generatedSqlQuery().get("orderdetails").get(3);
    }

    @Override
    public String getInsertSql() {
        return Database.generatedSqlQuery().get("orderdetails").get(4);
    }
}
