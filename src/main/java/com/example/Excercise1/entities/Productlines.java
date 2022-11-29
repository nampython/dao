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
public class Productlines implements ValueObject {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
    private String image;

    private int resultCode = 101;

    private String resultCodeMessage = null;

    public boolean isDirty;

    public Productlines(String productLine, String textDescription, String htmlDescription, String image) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
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
        return Database.generatedSqlQuery().get("productlines").get(1);
    }

    @Override
    public String getDeleteSql() {
        return Database.generatedSqlQuery().get("productlines").get(2);
    }

    @Override
    public String getUpdateSql() {
        return Database.generatedSqlQuery().get("productlines").get(3);
    }

    @Override
    public String getInsertSql() {
        return Database.generatedSqlQuery().get("productlines").get(4);
    }
}
