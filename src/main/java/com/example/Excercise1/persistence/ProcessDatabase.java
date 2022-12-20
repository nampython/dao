package com.example.Excercise1.persistence;

import com.example.Excercise1.exceptions.ConnectionException;
import com.example.Excercise1.exceptions.GeneratedSqlQueryException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

import static com.example.Excercise1.constants.MessageException.FAILED_TO_GET_CONNECTION;

@Component
public class ProcessDatabase {
    private static final Logger log = LogManager.getLogger(ProcessDatabase.class);

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
        String sql = "select * from information_schema.COLUMNS where TABLE_SCHEMA = ? and TABLE_NAME = ? order by  ordinal_position";

        try {
            cn = getConnection();
            meta = cn.getMetaData();
            rsGetTableName = meta.getTables(cn.getCatalog(), null, "%", new String [] {"TABLE"});
            while (rsGetTableName.next()) {
                String nameTable = rsGetTableName.getString(3);
                log.info("message=Executing auto-generated sql with table: " + nameTable);
                List<String> listOfColumName = new ArrayList<>();
                st = cn.prepareStatement(sql);
                st.setString(1, "classicmodels");
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
            throw new GeneratedSqlQueryException("Failed to generate sql query");
        }
    }

    private static Connection getConnection() {
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "admin");
        properties.setProperty("useSSL", "false");
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", properties);
        } catch (SQLException sqlException) {
            throw new ConnectionException(String.format(FAILED_TO_GET_CONNECTION, "classicmodels"), sqlException.getCause());
        }
    }
    /**
     * Use to process table to get the list of sql query based on table name
     * @param nameTable name of the  table
     * @param columnName column name
     * @return List of sql queries based on table
     */
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
