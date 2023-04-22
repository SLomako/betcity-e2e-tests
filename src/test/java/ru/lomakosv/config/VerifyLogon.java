package ru.lomakosv.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src/test/resources/verify.properties",
})
public interface VerifyLogon extends Config {

    @Key("verify")
    String verify();


}
