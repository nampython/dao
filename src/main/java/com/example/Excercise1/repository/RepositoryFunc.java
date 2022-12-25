package com.example.Excercise1.repository;

import com.example.Excercise1.valueObject.Value;

import java.sql.*;
import java.util.List;

public interface RepositoryFunc {
    public abstract void setSearchParams(PreparedStatement ps, List<Object> params);
    public abstract void setParam(PreparedStatement ps, Object obj, int j) throws SQLException;
    public abstract void processParams(String sql, List<Object> params);
    public abstract void getMultipleRows(ResultSet rs, List<List<Value>> values) throws SQLException;
}
