package com.example.Excercise1.database;

import com.example.Excercise1.exceptions.StatementException;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.Statement;

import static com.example.Excercise1.constants.MessageException.FAILED_TO_CLOSE_STATEMENT;

@Component
public class ProcessStatementImpl implements ProcessStatement{
    @Override
    public void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new StatementException(FAILED_TO_CLOSE_STATEMENT, e.getCause());
        }
    }
}
