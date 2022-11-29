package com.example.Excercise1;

import com.example.Excercise1.entities.Productlines;
import com.example.Excercise1.persistence.Database;
import com.example.Excercise1.repository.*;

import java.sql.*;
import java.util.List;
import java.util.Map;



public class JDBC {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from productlines where productLine = 'Classic Cars'";
        Dao dao = new DaoImpl();
//        StoredProcedures storedProcedures = new StoredProceduresImpl();
//        JdbcConcept jdbcConcept = new JdbcConceptImpl();
        Productlines productlines = new Productlines();
        productlines.setProductLine("11");
        productlines.setTextDescription("11");
        productlines.setHtmlDescription("11");
        productlines.setImage("11");
        List<Object> params = productlines.getParams();
        for (Object o : params) {
            System.out.println(o);
        }
//        dao.setValueObject(productlines);
        String sql1 = "getOfficeByCountry";
        String sql2 = "GetOrderCountByStatus";
        String sql3 = "insert into productlines(productLine, textDescription, htmlDescription, image) values (?, ?, ?, ?)";
        String sql4 = "insert into productlines(productLine, textDescription, htmlDescription, image) values ('?', ?, ?, ?)";
        String sql5 = "insert into productlines(productLine, textDescription, htmlDescription, image) values ('?', ?, ?, ?)";
        String sql6 = "select * from productlines";
//        for (Productlines productlines : dao.getListOfValueObject(sql6, Productlines.class)) {
//            System.out.println(productlines);
//        }
//        System.out.println(Arrays.toString(jdbcConcept.batchUpdatePreparedStatement(sql3,
//                Arrays.asList(
//                        Arrays.asList("1", "1", null, null),
//                        Arrays.asList("2", "2", null, null),
//                        Arrays.asList("3", "3", null, null),
//                        Arrays.asList("4", "4", null, null)
//                )
//        )));
//        CustomersEntity customersEntity = new CustomersEntity(1, "123", "weqw",
//                "wqe", "qwe", "wqeqw", "wqeqw", "wqe", "eqwe", "ewqe", "ewqeqw", 1, BigDecimal.valueOf(1));
//        EmployeesEntity ordersEntity = new EmployeesEntity(1, "2000/02/01", "02", "2", "we", "wqe", 1, "wqewq");
//        List<Object> params = ordersEntity.getParams();
//        ResultSet rs = null;
//        customersEntity.parseSql(rs);
//        Map<String, List<String>> map = Database.generatedSqlQuery();
//        List<String> customers = map.get("customers");
//        customers.forEach(System.out::println);
    }
//    Map<'Customer', Map<'update', '...', >>
}
