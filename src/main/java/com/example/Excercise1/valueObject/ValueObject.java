package com.example.Excercise1.valueObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ValueObject extends Cloneable{
    void parseSql(ResultSet var1) throws SQLException;
    void setResultCode(int var1);
    String getExecuteSql();
    List<Object> getParams();
    void clear();
    String getDeleteSql();
    String getInsertSql();
    String getUpdateSql();
    String getSelectSql();
    boolean isModified();
    int getResultCode();
}
