package ru.lomakosv.config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "system.properties",
        "classpath:auth.properties"

})
public interface AuthAccountNumberConfig  extends Config {

    @Key("accountNumber")
    String accountNumber();

    @Key("password")
    String password();


}
