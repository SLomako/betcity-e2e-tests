package ru.lomakosv.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})
public interface AuthAccountPhoneConfig extends Config {

    @Key("accountPhone")
    String accountPhone();

    @Key("password")
    String password();
}
