package com.example.Excercise1.database;

import java.sql.Connection;

public interface ProcessConnection {
    public abstract Connection getConnection();
    public abstract void closeConnection(Connection connection);
}
