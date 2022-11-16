package com.example.Excercise1;

import com.example.Excercise1.repository.Dao;
import com.example.Excercise1.repository.DaoImpl;
import com.example.Excercise1.valueObject.Value;

import java.sql.*;
import java.util.Arrays;
import java.util.List;


public class JDBC {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from productlines where productLine = 'Classic Cars'";
        Dao dao = new DaoImpl();
        System.out.println(dao.getSingleRow(sql));
    }
}
