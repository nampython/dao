package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.ConnectionException;
import com.example.Excercise1.exceptions.SetParameterException;
import com.example.Excercise1.exceptions.StatementException;
import com.example.Excercise1.valueObject.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import static com.example.Excercise1.constants.MessageException.*;

@Component
public class RepositoryFuncImpl implements RepositoryFunc {
    private final Environment env;
    private final DataSource dataSource;
    @Autowired
    public RepositoryFuncImpl(Environment env, DataSource dataSource) {
        this.env = env;
        this.dataSource = dataSource;
    }

    /** Use to set parameter of the object into PreparedStatement
     * @param ps PrepareStatement
     * @param params List of parameter
     */
    @Override
    public void setSearchParams(PreparedStatement ps, List<Object> params) {
        if (params == null) {
            throw new NullPointerException(INVALID_PARAMETER);
        }   
        try {
            for (int i = 0, j = 1; i < params.size(); i++, j++) {
                Object obj = params.get(i);
                setParam(ps, obj, j);
            }
        } catch (SQLException | UnsupportedOperationException  e) {
            throw new SetParameterException(String.format(FAILED_TO_SET_PARAMETER, params), e.getCause());
        }
    }

    @Override
    public void setParam(PreparedStatement ps, Object obj, int j) throws SQLException {
        if (obj == null) {
            ps.setString(j, null);
        } else if (obj instanceof String) {
            ps.setString(j, (String) obj);
        } else if (obj instanceof Integer) {
            ps.setInt(j, (Integer) obj);
        } else if (obj instanceof Date) {
            ps.setDate(j, (Date) obj);
        } else if (obj instanceof BigDecimal) {
            ps.setBigDecimal(j, (BigDecimal) obj);
        } else if (obj instanceof Long) {
            ps.setLong(j, (Long) obj);
        } else if (obj instanceof Double) {
            ps.setDouble(j, (Double) obj);
        } else if (obj instanceof Float) {
            ps.setFloat(j, (Float) obj);
        } else if (obj instanceof Short) {
            ps.setFloat(j, (Short) obj);
        }
        else {
            throw new UnsupportedOperationException("The type " + obj.getClass().getName() + " is currently not supported.");
        }
    }

    /**
     * @param sql
     * @param params
     */
    @Override
    public void processParams(String sql, List<Object> params) {
        // TODO - Complete this function
    }

    /**
     * Use to get multiple rows
     * @param rs
     * @param values
     * @throws SQLException
     */
    @Override
    public void getMultipleRows(ResultSet rs, List<List<Value>> values) throws SQLException {
        ResultSetMetaData metaData;
        int columnCount;
        while (rs.next()) {
            metaData = rs.getMetaData();
            columnCount = metaData.getColumnCount();
            if (columnCount <= 0) {
                continue;
            }
            List<Value> row = new ArrayList<>();
            for (int j = 1; j <= columnCount; j++) {
                Object o = rs.getObject(j);
                row.add(new Value(o));
            }
            values.add(row);
        }
    }
}
