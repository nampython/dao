package com.example.Excercise1.database;

import java.sql.Statement;

public interface StatementDB {
    public abstract void closeStatement(Statement statement);
}
