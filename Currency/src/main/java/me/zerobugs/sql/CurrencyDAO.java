package me.zerobugs.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CurrencyDAO extends TableCreator{


    public void addOrUpdateValue(UUID uuid, double value, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(SQLQueries.ADD_OR_UPDATE_VALUE.getQuery())) {
            statement.setObject(1, uuid);
            statement.setDouble(2, value);
            statement.setDouble(3, value);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getValue(UUID uuid, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_VALUE.getQuery())) {
            statement.setObject(1, uuid);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("value");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
