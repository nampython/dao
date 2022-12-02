package com.example.Excercise1.entities;

import com.example.Excercise1.persistence.CommonEntities;
import com.example.Excercise1.persistence.ProcessDatabase;
import com.example.Excercise1.valueObject.ValueObject;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Payments implements ValueObject {
    private int customerNumber;
    private String checkNumber;
    private Date paymentDate;
    private BigDecimal amount;

    private int resultCode = 101;

    private String resultCodeMessage = null;

    public boolean isDirty;

    public Payments(int customerNumber, String checkNumber, Date paymentDate, BigDecimal amount) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
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
    public void setResultCode(int var1) {

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
    public String getSelectSql() {
        return ProcessDatabase.generatedSqlQuery().get("payments").get(1);
    }

    @Override
    public String getDeleteSql() {
        return ProcessDatabase.generatedSqlQuery().get("payments").get(2);
    }

    @Override
    public String getUpdateSql() {
        return ProcessDatabase.generatedSqlQuery().get("payments").get(3);
    }

    @Override
    public String getInsertSql() {
        return ProcessDatabase.generatedSqlQuery().get("payments").get(4);
    }
}
