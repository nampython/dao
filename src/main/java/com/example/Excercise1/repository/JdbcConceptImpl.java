package com.example.Excercise1.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.List;


@Repository
public class JdbcConceptImpl implements JdbcConcept {

    @Autowired
    private RepositoryFunc repositoryFunc;

    @Override
    public int getAutoIncrementValue(String sql) {
        ResultSet rs = null;
        Connection conn = null;
        Statement statement = null;
        try {
            int autoIncKeyFromApi = -1;
            conn = repositoryFunc.getConnection();
            statement = conn.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
            }
            return autoIncKeyFromApi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void resultSetConcurrency() {
        Connection cnn = null;
        Statement statement = null;
        ResultSet rs = null;
        String sql = "select * from productlines";
        try {
            cnn = repositoryFunc.getConnection();
            statement = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String productLine = rs.getString(1);
                rs.updateString(1, productLine + "nam");
                //update the database
                rs.updateRow();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int[] batchUpdateStatement(List<Object> sql) {
        Connection cnn = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            cnn = repositoryFunc.getConnection();
            cnn.setAutoCommit(false);
            statement = cnn.createStatement();
            for (Object s : sql) {
                if (s instanceof String) {
                    statement.addBatch((String) s);
                }
            }
            int[] updateCounts = statement.executeBatch();
            cnn.commit();
            return updateCounts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int[] batchUpdatePreparedStatement(String sql, List<List<Object>> params) {
        Connection cnn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            cnn = repositoryFunc.getConnection();
            cnn.setAutoCommit(false);
            ps = cnn.prepareStatement(sql);
            for (List<Object> param : params) {
                repositoryFunc.setSearchParams(ps, param);
                ps.addBatch();
            }
            int[] updateCount = ps.executeBatch();
            cnn.commit();
            return updateCount;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertingRowsWithResultSetObjects(String sql, List<Object> params) {
        Connection cnn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            cnn = repositoryFunc.getConnection();
            st = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sql);
            rs.moveToInsertRow();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
