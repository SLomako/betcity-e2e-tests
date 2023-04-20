package ru.lomakosv.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",

})
public interface AuthAccountPhoneConfig extends Config {

    @Key("accountPhone")
    String accountPhone();

    @Key("password")
    String password();


}
