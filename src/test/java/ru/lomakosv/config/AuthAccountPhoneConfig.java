package ru.lomakosv.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:C:\\Users\\lomak\\auth.properties",
        "classpath:auth.properties"


})
public interface AuthAccountPhoneConfig extends Config {

    @Key("accountPhone")
    String accountPhone();

    @Key("password")
    String password();


}
