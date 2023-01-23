package me.zerobugs.currency;

import me.zerobugs.Currency;
import me.zerobugs.sql.HikariCPConfig;

import java.util.UUID;

public final class CurrencyHandler {

    private final HikariCPConfig hikariCPConfig;
    public CurrencyHandler(){
        hikariCPConfig = Currency.getCurrency()
                .getHikariCPConfig();
    }


    public void addBalance(UUID uuid, double amount){
        setBalance(uuid, (getBalance(uuid)+amount));
    }

    public void removeBalance(UUID uuid, double amount){
        setBalance(uuid, (getBalance(uuid)-amount));
    }

    public void setBalance(UUID uuid, double amount){
        hikariCPConfig.addOrUpdateValue(uuid, amount, hikariCPConfig.getConnection());
    }


    public void resetBalance(UUID uuid){
        setBalance(uuid, 0);
    }

    public double getBalance(UUID uuid){
        return hikariCPConfig.getValue(uuid, hikariCPConfig.getConnection());
    }



}
