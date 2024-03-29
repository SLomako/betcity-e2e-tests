package ru.lomakosv.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static WebConfig getWebConfig() {
        return ConfigCache.getOrCreate(WebConfig.class, System.getProperties());
    }

    public static AuthAccountNumberConfig getAuthAccountNumberConfig() {
        return ConfigCache.getOrCreate(AuthAccountNumberConfig.class);
    }

    public static AuthAccountPhoneConfig getAuthAccountPhoneConfig() {
        return ConfigCache.getOrCreate(AuthAccountPhoneConfig.class);
    }

    public static SelenoidConfig getAuthSelenoidConfig() {
        return ConfigCache.getOrCreate(SelenoidConfig.class);
    }
}
