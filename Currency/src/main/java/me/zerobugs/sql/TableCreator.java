package me.zerobugs.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {

    public void createTable(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(SQLQueries.CREATE_TABLE.getQuery());
            System.out.println("Table created successfully!");
        } catch (SQLException exception) {
            System.err.println("Error creating table: " + exception.getMessage());
        }
    }


}
