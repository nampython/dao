package com.example.Excercise1.persistence;

import com.example.Excercise1.enviroments.EnvironmentConfiguration;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.example.Excercise1.repository.FunctionalCommon.*;

public class ProcessDatabase {

    // CUSTOMER TABLE
    public static final String CUSTOMER_UPDATE_SQL = "update customersGetTableName set customerName = ?, contactLastName = ?, contactFirsGetTableNametName = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, city = ?, state = ?, postalCode = ?, country = ?, salesRepEmployeeNumber = ?, creditLimit = ? where customerNumber = ?";
    public static final String CUSTOMER_INSERT_SQL = "insert into customersGetTableName(customerNumber, customerName, contactLastName, contactFirsGetTableNametName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String CUSTOMER_DELETE_SQL = "delete from customersGetTableName where customerNumber = ?";
    public static final String CUSTOMER_SELECT_SQL = "select * from customersGetTableName";


    /**
     * Use to generate sql queries for entities
     * @return Map<String, List<String>>
     */
    public static Map<String, List<String>> generatedSqlQuery() {
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rsGetTableName = null;
        ResultSet rsGetColumnName = null;
        DatabaseMetaData meta = null;
        Map<String, List<String>> totalQuery = new HashMap<>();
        String sql = EnvironmentConfiguration.properties().getProperty("sql.select.tables");

        try {
            cn = getConnection();
            meta = cn.getMetaData();
            rsGetTableName = meta.getTables(cn.getCatalog(), null, "%", new String [] {"TABLE"});
            while (rsGetTableName.next()) {
                String nameTable = rsGetTableName.getString(3);
                List<String> listOfColumName = new ArrayList<>();

                st = cn.prepareStatement(sql);
                st.setString(1, EnvironmentConfiguration.properties().getProperty("jdbc.schema"));
                st.setString(2, nameTable);
                rsGetColumnName = st.executeQuery();
                while (rsGetColumnName.next()) {
                    String columnName = rsGetColumnName.getString(4);
                    listOfColumName.add(columnName);
                }
                List<String> generatedQueries = processTable(nameTable, listOfColumName);
                totalQuery.put(nameTable, generatedQueries);
            }
            return totalQuery;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    "update customersGetTableName set customerName = ?, contactLastName = ?, contactFirsGetTableNametName = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, city = ?, state = ?, postalCode = ?, country = ?, salesRepEmployeeNumber = ?, creditLimit = ? where customerNumber = ?";
//   "insert into customersGetTableName(customerNumber, customerName, contactLastName, contactFirsGetTableNametName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";USTOMER_UPDATE_SQL = "update customersGetTableName set customerName = ?, contactLastName = ?, contactFirsGetTableNametName = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, city = ?, state = ?, postalCode = ?, country = ?, salesRepEmployeeNumber = ?, creditLimit = ? where customerNumber = ?";

    private static List<String> processTable(String nameTable, List<String> columnName) {
        List<String> queries = new ArrayList<>();
        String querySelect = String.format("select * from %s", nameTable);
        String queryDelete = String.format("delete from %s where %s = ?", nameTable, columnName.get(0));
        queries.add(querySelect);
        queries.add(queryDelete);

        String preQueryUpdate = "update " + nameTable +" set ";
        String preQueryInsert = "insert into " + nameTable + " ( ";
        StringBuilder queryUpdate = new StringBuilder(preQueryUpdate);
        StringBuilder queryInsert = new StringBuilder(preQueryInsert);
        String firstEle = columnName.get(0);
        int size = columnName.size();
        int j = 0;
        for (int i = 1; i < size; i++) {
            if (i == 1) {
                queryInsert.append(columnName.get(0)).append(", ");
            }
            if (i == columnName.size() -1 ) {
                queryUpdate.append(columnName.get(i)).append(" = ? ");
                queryInsert.append(columnName.get(i)).append(" )");
            } else {
                queryUpdate.append(columnName.get(i)).append(" = ?, ");
                queryInsert.append(columnName.get(i)).append(", ");
            }
        }
        queryUpdate.append("where ").append(firstEle).append(" = ?");
        queryInsert.append(" values ( ");
        while (size > 0) {
            if (size == 1 ) {
                queryInsert.append(" ? )");
                break;
            }
            queryInsert.append(" ?, ");
            size--;
        }
        queries.add(String.valueOf(queryUpdate));
        queries.add(String.valueOf(queryInsert));
        return queries;
    }

    public static void generatedSqlQueryByReflection() {
        // TODO: Complete this function by Java Reflection
    }
}
