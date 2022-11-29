package com.example.Excercise1.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.Excercise1.repository.FunctionalCommon.*;

public class Database {
    public static String URL = "jdbc:mysql://localhost:3306/classicmodels";
    public static String USER = "root";
    public static String PW = "admin";
    public static String SCHEMA = "classicmodels";

    // CUSTOMER TABLE
    public static final String CUSTOMER_UPDATE_SQL = "update customersGetTableName set customerName = ?, contactLastName = ?, contactFirsGetTableNametName = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, city = ?, state = ?, postalCode = ?, country = ?, salesRepEmployeeNumber = ?, creditLimit = ? where customerNumber = ?";
    public static final String CUSTOMER_INSERT_SQL = "insert into customersGetTableName(customerNumber, customerName, contactLastName, contactFirsGetTableNametName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String CUSTOMER_DELETE_SQL = "delete from customersGetTableName where customerNumber = ?";
    public static final String CUSTOMER_SELECT_SQL = "select * from customersGetTableName";

    // EMPLOYEES TABLE
    public static final String EMPLOYEES_UPDATE_SQL = "update employees set lastName = ?, firsGetTableNametName = ?, extension = ?, email = ?, officeCode = ?, reportsTo = ?, jobTitle = ? where employeeNumber = ?";
    public static final String EMPLOYEES_INSERT_SQL = "insert into employees(lastName, firsGetTableNametName, extension, email, officeCode, reportsTo, jobTitle) values (?, ?, ?, ?, ?, ?, ?);";
    public static final String EMPLOYEES_DELETE_SQL = "delete from employees where employeeNumber = ?;";
    public static final String EMPLOYEES_SELECT_SQL = "select * from employees";

    //   OFFICE TABLE
    public static final String OFFICE_UPDATE_SQL = "update offices set  city  = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, state = ?, country = ?, postalCode = ?, territory = ? where officeCode = ?;";
    public static final String OFFICE_INSERT_SQL = "insert into offices (officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String OFFICE_DELETE_SQL = "delete from offices where officeCode = ?;";
    public static final String OFFICE_SELECT_SQL = "select * from offices";

    // ORDER DETAILS TABLE
    public static final String ORDER_DETAILS_UPDATE_SQL = "update orderdetails set  productCode = ?, quantityOrdered = ?, priceEach = ?, orderLineNumber = ? where orderNumber = ?;";
    public static final String ORDER_DETAILS_INSERT_SQL = "insert into orderdetails (orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber) values (?, ?, ?, ?, ?);";
    public static final String ORDER_DETAILS_DELETE_SQL = "delete from orderdetails where orderNumber = ?;";
    public static final String ORDER_DETAILS_SELECT_SQL = "select * from orderdetails";


    public static Map<String, List<String>> generatedSqlQuery() {
        String sql = "select * from information_schema.COLUMNS where TABLE_SCHEMA = ? and TABLE_NAME = ? order by  ordinal_position;";
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rsGetTableName = null;
        ResultSet rsGetColumnName = null;
        DatabaseMetaData meta = null;
        Map<String, List<String>> totalQuery = new HashMap<>();

        try {
            cn = getConnection();
            meta = cn.getMetaData();
            rsGetTableName = meta.getTables(cn.getCatalog(), null, "%", new String [] {"TABLE"});
            while (rsGetTableName.next()) {
                String nameTable = rsGetTableName.getString(3);
                List<String> listOfColumName = new ArrayList<>();
                st = cn.prepareStatement(sql);
                st.setString(1, SCHEMA);
                st.setString(2, nameTable);
                rsGetColumnName = st.executeQuery();
                while (rsGetColumnName.next()) {
                    String columnName = rsGetColumnName.getString(4);
                    listOfColumName.add(columnName);
                }
                List<String> generatedqueries = processTable(nameTable, listOfColumName);
                totalQuery.put(nameTable, generatedqueries);
            }
            return totalQuery;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static List<String> processTable(String nameTable, List<String> columnName) {
        List<String> queries = new ArrayList<>();
        String querySelect = String.format("select * from %s", nameTable);
        String queryDelete = String.format("delete from %s where %s = ?", nameTable, columnName.get(0));
        queries.add(querySelect);
        queries.add(queryDelete);

        String preQueryUpdate = "update " + nameTable +" set ";
        String preQueryInsert = "insert into " + nameTable + "(";
        StringBuilder queryUpdate = new StringBuilder(preQueryUpdate);
        StringBuilder queryInsert = new StringBuilder(preQueryInsert);
        String firstEle = columnName.get(0);

        for (int i = 1; i < columnName.size(); i++) {
            if (i == columnName.size() -1 ) {
                queryUpdate.append(columnName.get(i)).append(" = ? ");
            }
            queryUpdate.append(columnName.get(i)).append(" = ?, ");
            queryInsert.append(columnName.get(i-1)).append(", ");
        }
        queryUpdate.append("where ").append(firstEle).append(" = ?");
        queries.add(String.valueOf(queryUpdate));
        queries.add(String.valueOf(queryInsert));
        return queries;
    }

    public static void generatedSqlQueryByReflection() {
        // TODO: Complete this function by Java Reflection

    }
}
