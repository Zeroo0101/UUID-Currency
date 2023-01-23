package me.zerobugs;

import me.zerobugs.config.ConfigHandler;
import me.zerobugs.currency.CurrencyHandler;
import me.zerobugs.sql.HikariCPConfig;

public final class Currency{

    private static Currency currency;
    private static ConfigHandler configHandler;
    private static HikariCPConfig hikariCPConfig;
    private static CurrencyHandler currencyHandler;

    private static void onEnable(){

        configHandler = new ConfigHandler()
                .deleteConfig("config")
                .createConfig("config");

        hikariCPConfig = new HikariCPConfig();
        hikariCPConfig.createTable(hikariCPConfig.getConnection());

        currencyHandler = new CurrencyHandler();
    }

    public void reload(){
        onEnable();
    }

    public static Currency getCurrency(){
        if (currency == null){
            currency = new Currency();
            onEnable();
        }
        return currency;
    }

    public ConfigHandler getConfigHandler(){
        return configHandler;
    }
    public HikariCPConfig getHikariCPConfig(){
        return hikariCPConfig;
    }

    public CurrencyHandler getCurrencyHandler(){
        return currencyHandler;
    }
}
