package com.example.Excercise1;

import com.example.Excercise1.repository.*;

import java.sql.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;



public class JDBC {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from productlines where productLine = 'Classic Cars'";
        Dao dao = new DaoImpl();
        StoredProcedures storedProcedures = new StoredProceduresImpl();
        JdbcConcept jdbcConcept = new JdbcConceptImpl();
//        Productlines productlines = new Productlines();
//        productlines.setProductLine("11");
//        productlines.setTextDescription("11");
//        productlines.setHtmlDescription("11");
//        productlines.setImg("11");
//        dao.setValueObject(productlines);
        String sql1 = "getOfficeByCountry";
        String sql2 = "GetOrderCountByStatus";
        String sql3 = "insert into productlines(productLine, textDescription, htmlDescription, image) values (?, ?, ?, ?)";
        String sql4 = "insert into productlines(productLine, textDescription, htmlDescription, image) values ('?', ?, ?, ?)";
        String sql5 = "insert into productlines(productLine, textDescription, htmlDescription, image) values ('?', ?, ?, ?)";

        System.out.println(Arrays.toString(jdbcConcept.batchUpdatePreparedStatement(sql3,
                Arrays.asList(
                        Arrays.asList("1", "1", null, null),
                        Arrays.asList("2", "2", null, null),
                        Arrays.asList("3", "3", null, null),
                        Arrays.asList("4", "4", null, null)
                )
        )));
    }
}
