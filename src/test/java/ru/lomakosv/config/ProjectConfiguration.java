package ru.lomakosv.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class ProjectConfiguration {

    public static WebConfig webConfig = ConfigurationManager.getWebConfig();
    public static AuthSelenoidConfig authSelenoidConfig = ConfigurationManager.getAuthSelenoidConfig();

    public void config() {

        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();

        if (webConfig.isRemote()) {
            selenoidVideo();
        }

    }
    public void selenoidVideo() {
        String remoteUrl = webConfig.remoteUrl();
        Configuration.remote = "https://" + authSelenoidConfig.remote_username() + ":" + authSelenoidConfig.remote_password() + "@" + remoteUrl  + "/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

}
