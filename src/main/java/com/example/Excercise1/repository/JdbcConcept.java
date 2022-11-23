package com.example.Excercise1.repository;

import java.sql.SQLException;
import java.util.List;

public interface JdbcConcept {
    public abstract int getAutoIncrementValue(String sql);
    public abstract void resultSetConcurrency();
    public abstract int[] batchUpdateStatement(List<Object> sql);
    public abstract int[] batchUpdatePreparedStatement(String sql, List<List<Object>> params);
    public abstract void insertingRowsWithResultSetObjects(String sql, List<Object>params) throws SQLException;
}
