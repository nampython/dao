package com.example.Excercise1.valueObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ValueObject extends Cloneable{
    void parseSql(ResultSet var1) throws SQLException;
    void setResultCode(int var1);
    Object clone() throws CloneNotSupportedException;
    String getExecuteSql();
    List<Object> getParams();

}
