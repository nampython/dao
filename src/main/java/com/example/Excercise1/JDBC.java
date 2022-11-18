package com.example.Excercise1;

import com.example.Excercise1.repository.Dao;
import com.example.Excercise1.repository.DaoImpl;
import com.example.Excercise1.repository.StoredProcedures;
import com.example.Excercise1.repository.StoredProceduresImpl;
import java.sql.*;
import java.util.Collections;
import java.util.Map;



public class JDBC {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from productlines where productLine = 'Classic Cars'";
        Dao dao = new DaoImpl();
        StoredProcedures storedProcedures = new StoredProceduresImpl();
//        Productlines productlines = new Productlines();
//        productlines.setProductLine("11");
//        productlines.setTextDescription("11");
//        productlines.setHtmlDescription("11");
//        productlines.setImg("11");
//        dao.setValueObject(productlines);
        String sql1 = "getOfficeByCountry";
        String sql2 = "GetOrderCountByStatus";
        Map<Integer, Object> map = storedProcedures.executeProcedureWithInputAndOutputParams(sql2, Collections.singletonMap(1, "Shipped"), Collections.singletonMap(2, Types.INTEGER));
        map.entrySet().forEach(System.out::println);
    }
}
