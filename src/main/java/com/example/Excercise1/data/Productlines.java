package com.example.Excercise1.data;

import com.example.Excercise1.mars.ValueObject;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public String getSelectSql() {
        return null;
    }

    @Override
    public List getParams() {
        return null;
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
