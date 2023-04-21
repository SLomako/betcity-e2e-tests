package ru.lomakosv.config;

import org.aeonbits.owner.Config;
import ru.lomakosv.enums.Browser;

@Config.Sources({
        "system.properties",
        "classpath:${env}.properties"}
)
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    Browser browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://betcity.ru/")
    String baseUrl();

    @DefaultValue("false")
    @Key("isRemote")
    boolean isRemote();

    @Key("remoteUrl")
    String remoteUrl();
}
