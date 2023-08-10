package ru.lomakosv.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties",
        "classpath:${env}.properties"
})
public interface SelenoidConfig extends Config {

    @Key("username.selenoid")
    String userName();

    @Key("password.selenoid")
    String password();

}

