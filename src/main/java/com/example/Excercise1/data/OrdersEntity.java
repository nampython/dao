package com.example.Excercise1.data;

import com.example.Excercise1.valueObject.ValueObject;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrdersEntity implements ValueObject {
    private int orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private int customerNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return orderNumber == that.orderNumber && customerNumber == that.customerNumber && Objects.equals(orderDate, that.orderDate) && Objects.equals(requiredDate, that.requiredDate) && Objects.equals(shippedDate, that.shippedDate) && Objects.equals(status, that.status) && Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderDate, requiredDate, shippedDate, status, comments, customerNumber);
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
//        if (this.resultCode == 101) {
//            sql = "insert into bank (ABBRV,AUD_USER,DESCR,PK_BANK_ID) values (?,?,?,?)";
//        } else if (this.resultCode == 0) {
//            sql = "update bank set ABBRV=?,AUD_USER=?,DESCR=? where PK_BANK_ID=?";
//        } else if (this.resultCode == 103) {
//            sql = "delete bank where PK_BANK_ID=?";
//        }
        sql = "INSERT INTO orders(orderNumber, orderDate, requiredDate,shippedDate,status, customerNumber) VALUES(?, ?, ?, ?, ?, ?);";
        return sql;
    }



    @Override
    public List getParams() {
//        List params = null;
//        if (this.resultCode == 103) {
//            params = this.getPkParams();
//        } else {
//            params = new ArrayList(4);
//            ((List)params).add(this.abbrv);
//            ((List)params).add(SecurityManager.getUserId());
//            ((List)params).add(this.descr);
//            ((List)params).addAll(this.getPkParams());
//        }
//
//        return (List)params;
        List<java.io.Serializable> params = new ArrayList<>(6);
        params.add(this.orderNumber);
        params.add(this.orderDate);
        params.add(this.requiredDate);
        params.add(this.shippedDate);
        params.add(this.status);
        params.add(this.customerNumber);
        return params;
    }

}
