package com.example.Excercise1.entities;

import com.example.Excercise1.persistence.CommonEntities;
import com.example.Excercise1.persistence.ProcessDatabase;
import com.example.Excercise1.valueObject.ValueObject;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.example.Excercise1.constants.ResultCode.*;

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
    public void clear() {
        CommonEntities.processClear(this);
    }

    @Override
    public void parseSql(ResultSet rs) throws SQLException {
        CommonEntities.processesParseSql(this, rs);
    }

    @Override
    public void setResultCode(int var1) {

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
                sqlQuery = ProcessDatabase.generatedSqlQuery().get("productlines").get(3);
            }
            case UPDATE_CODE: {
                sqlQuery = ProcessDatabase.generatedSqlQuery().get("productlines").get(2);

            }
            case DELETE_CODE: {
                sqlQuery = ProcessDatabase.generatedSqlQuery().get("productlines").get(1);
            }
        }
        return sqlQuery;
    }

    @Override
    public List<Object> getParams() {
        return CommonEntities.getParams(this);
    }

    @Override
    public String getSelectSql() {
        return ProcessDatabase.generatedSqlQuery().get("productlines").get(1);
    }

    @Override
    public String getDeleteSql() {
        return ProcessDatabase.generatedSqlQuery().get("productlines").get(2);
    }

    @Override
    public String getUpdateSql() {
        return ProcessDatabase.generatedSqlQuery().get("productlines").get(3);
    }

    @Override
    public String getInsertSql() {
        return ProcessDatabase.generatedSqlQuery().get("productlines").get(4);
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
