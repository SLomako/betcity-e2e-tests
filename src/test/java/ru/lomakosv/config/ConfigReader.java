package ru.lomakosv.config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;


    public static final WebConfig
            webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    public WebConfig read() {
        return webConfig;
    }
}


