package me.zerobugs.config;

import me.zerobugs.Currency;

public enum Config {


    THREAD_POOL_AMOUNT("thread-pools-amount");

    private final Currency currency;
    private final String path;

    Config(String path){
        currency = Currency.getCurrency();
        this.path = path;
    }

    public String getString(){
        return currency.getConfigHandler()
                .getConfig("config")
                .getString(path);
    }

    public int getInt(){
        return currency.getConfigHandler()
                .getConfig("config")
                .getInt(path);
    }



}
