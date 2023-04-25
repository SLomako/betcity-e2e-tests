package ru.lomakosv.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"}
)
public interface WebConfig extends Config {

    @DefaultValue("chrome, 112.0")
    @Key("browserWithVersion")
    String[] getBrowserAndVersion();

    @DefaultValue("1920x1080")
    @Key("browserSize")
    String browserSize();

    @DefaultValue("https://betcity.ru")
    @Key("baseUrl")
    String baseUrl();

    @DefaultValue("false")
    @Key("isRemote")
    boolean isRemote();

    @Key("remoteUrl")
    String remoteUrl();
}
