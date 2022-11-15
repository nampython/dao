package com.example.Excercise1.data;

import com.example.Excercise1.mars.ValueObject;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderdetailsEntity implements ValueObject {
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private BigDecimal priceEach;
    private short orderLineNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderdetailsEntity that = (OrderdetailsEntity) o;
        return orderNumber == that.orderNumber && quantityOrdered == that.quantityOrdered && orderLineNumber == that.orderLineNumber && Objects.equals(productCode, that.productCode) && Objects.equals(priceEach, that.priceEach);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber);
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
        String sql = "INSERT INTO orderdetails(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber)" +
                " VALUES(?, ?, ?, ?, ?);";
        return sql;
    }

    @Override
    public String getSelectSql() {
        return null;
    }

    @Override
    public List getParams() {
        List<java.io.Serializable> params = new ArrayList<>(6);
        params.add(this.orderNumber);
        params.add(this.productCode);
        params.add(this.quantityOrdered);
        params.add(this.priceEach);
        params.add(this.orderLineNumber);
        return params;
    }

    @Override
    public List getPkParams() {
        return null;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public int getResultCode() {
        return 0;
    }

    @Override
    public String getDeleteSql() {
        return null;
    }

    @Override
    public String getInsertSql() {
        return null;
    }

    @Override
    public String getUpdateSql() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void setModified(boolean var1) {

    }
}
