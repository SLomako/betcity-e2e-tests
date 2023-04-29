package ru.lomakosv.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"

})
public interface AuthSelenoidConfig extends Config {

    @Key("username.selenoid")
    String remote_username();

    @Key("password.selenoid")
    String remote_password();
}

