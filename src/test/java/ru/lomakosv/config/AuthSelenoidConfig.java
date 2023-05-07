package ru.lomakosv.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})
public interface AuthSelenoidConfig extends Config {

    @Key("username.selenoid")
    String getRemoteUsername();

    @Key("password.selenoid")
    String getRemotePassword();
}

