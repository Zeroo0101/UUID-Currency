package me.zerobugs.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.zerobugs.config.Config;

import java.sql.Connection;
import java.sql.SQLException;

public final class HikariCPConfig extends CurrencyDAO{

    private HikariDataSource dataSource;
    private Connection connection;

    public HikariCPConfig(){

        init();

        try {
            connection = dataSource.getConnection();
        } catch (SQLException exception){
            exception.printStackTrace();
        }

    }

    private void init(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlite:" + System.getProperty("user.dir") + "/Currency/currency.db");
        config.setDriverClassName("org.sqlite.JDBC");
        config.setMaximumPoolSize(Config.THREAD_POOL_AMOUNT.getInt());
        config.setConnectionTestQuery("SELECT 1");
        config.setPoolName("CurrencyThreadPool");
        dataSource = new HikariDataSource(config);
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection(){
        return connection;
    }

}
