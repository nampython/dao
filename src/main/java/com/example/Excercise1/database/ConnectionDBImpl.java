package com.example.Excercise1.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class ConnectionDBImpl implements ConnectionDB {
    private final DataSource dataSource;
    @Autowired
    public ConnectionDBImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Use to connect to database
     *
     * @return Connection
     */
    @Override
    public Connection getConnection() {
        return DataSourceUtils.getConnection(this.dataSource);
//        Properties properties = new Properties();
//        properties.setProperty("user", env.getProperty("jdbc.user"));
//        properties.setProperty("password", env.getProperty("jdbc.password"));
//        properties.setProperty("useSSL", "false");
//        try {
//            return DriverManager.getConnection(Objects.requireNonNull(env.getProperty("jdbc.url")), properties);
//        } catch (SQLException sqlException) {
//            throw new ConnectionException(String.format(FAILED_TO_GET_CONNECTION, env.getProperty("jdbc.schema")), sqlException.getCause());
//        }
    }

    /**
     * Use to close the connection
     * @param connection {@link Connection}
     */
    @Override
    public void closeConnection(Connection connection) {
//        try {
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (SQLException e) {
//            throw new ConnectionException(FAILED_TO_CLOSE_CONNECTION, e.getCause());
        DataSourceUtils.releaseConnection(connection, this.dataSource);
    }
}
