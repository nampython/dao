package com.example.Excercise1.entities;

import com.example.Excercise1.valueObject.ValueObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Productlines implements ValueObject {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;

    public Productlines(String productLine, String textDescription, String htmlDescription, String image) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.image = image;
    }

    public Productlines() {
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public void parseSql(ResultSet rs) throws SQLException {
        CommonEntities.processesParseSql(this, rs);
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
        String sql = "insert into productlines(productLine, textDescription, htmlDescription, image) values (?, ?, ?, ?)";
        return sql;
    }

    @Override
    public List<Object> getParams() {
        List<Object> objects = new ArrayList<>();
        objects.add(this.productLine);
        objects.add(this.image);
        objects.add(this.htmlDescription);
        objects.add(this.textDescription);
        return objects;
    }

    @Override
    public void clear() {
        CommonEntities.processClear(this);
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
    public String getSelectSql() {
        return null;
    }

    @Override
    public String toString() {
        return "Productlines{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
