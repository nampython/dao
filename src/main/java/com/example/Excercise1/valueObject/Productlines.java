package com.example.Excercise1.valueObject;

import com.example.Excercise1.valueObject.ValueObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Productlines implements ValueObject {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String img;

    public Productlines(String productLine, String textDescription, String htmlDescription, String img) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public void parseSql(ResultSet rs) throws SQLException {
        this.productLine = rs.getString("productLine");
        this.textDescription = rs.getString("textDescription");
        this.htmlDescription = rs.getString("htmlDescription");
        this.img = rs.getString("image");
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
        objects.add(this.img);
        objects.add(this.htmlDescription);
        objects.add(this.textDescription);
        return objects;
    }

    @Override
    public String toString() {
        return "Productlines{" +
                "productLine='" + productLine + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
