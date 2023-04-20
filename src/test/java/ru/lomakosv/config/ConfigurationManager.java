package ru.lomakosv.config;


import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static WebConfig getWebConfig() {
        return ConfigCache.getOrCreate(WebConfig.class, System.getProperties());
    }

    public  static AuthAccountNumberConfig getAuthAccountNumberConfig() {
        return ConfigCache.getOrCreate(AuthAccountNumberConfig.class, System.getProperties());
    }
}
