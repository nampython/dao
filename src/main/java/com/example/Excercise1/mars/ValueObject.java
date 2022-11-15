package com.example.Excercise1.mars;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ValueObject extends Cloneable{
    void parseSql(ResultSet var1) throws SQLException;

    void setResultCode(int var1);

    Object clone() throws CloneNotSupportedException;

    String getExecuteSql();

    String getSelectSql();

    List getParams();

    List getPkParams();

    boolean isModified();

    int getResultCode();

    String getDeleteSql();

    String getInsertSql();

    String getUpdateSql();

    void clear();

    void setModified(boolean var1);
}
