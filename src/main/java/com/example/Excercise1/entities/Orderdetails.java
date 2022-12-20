package com.example.Excercise1.entities;

import com.example.Excercise1.persistence.CommonEntities;
import com.example.Excercise1.persistence.ProcessDatabase;
import com.example.Excercise1.valueObject.ValueObject;
import lombok.*;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.example.Excercise1.constants.ResultCode.*;

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
    public void clear() {
        CommonEntities.processClear(this);
    }

    @Override
    public void parseSql(ResultSet rs) throws SQLException {
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
                sqlQuery = ProcessDatabase.generatedSqlQuery().get("orderdetails").get(3);
                break;
            }
            case UPDATE_CODE: {
                sqlQuery = ProcessDatabase.generatedSqlQuery().get("orderdetails").get(2);
                break;
            }
            case DELETE_CODE: {
                sqlQuery = ProcessDatabase.generatedSqlQuery().get("orderdetails").get(1);
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
        return ProcessDatabase.generatedSqlQuery().get("orderdetails").get(1);
    }

    @Override
    public String getDeleteSql() {
        return ProcessDatabase.generatedSqlQuery().get("orderdetails").get(2);
    }

    @Override
    public String getUpdateSql() {
        return ProcessDatabase.generatedSqlQuery().get("orderdetails").get(3);
    }

    @Override
    public String getInsertSql() {
        return ProcessDatabase.generatedSqlQuery().get("orderdetails").get(4);
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
