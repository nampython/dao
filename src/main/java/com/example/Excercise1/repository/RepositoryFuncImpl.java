package com.example.Excercise1.repository;

import com.example.Excercise1.exceptions.SetParameterException;
import com.example.Excercise1.valueObject.Value;
import com.example.Excercise1.valueUtils.SetValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static com.example.Excercise1.constants.MessageException.*;

@Component
public class RepositoryFuncImpl implements RepositoryFunc {
    private final Environment env;
    private final SetValue setValue;
    @Autowired
    public RepositoryFuncImpl(Environment env, SetValue setValue) {
        this.env = env;
        this.setValue = setValue;
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
                this.setValue.setParamsPreStatement(ps, obj, j);
            }
        } catch (UnsupportedOperationException | SQLException e) {
            throw new SetParameterException(String.format(FAILED_TO_SET_PARAMETER, params), e.getCause());
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
