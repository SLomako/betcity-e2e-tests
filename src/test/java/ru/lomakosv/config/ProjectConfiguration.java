package ru.lomakosv.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfiguration {

    public static WebConfig webConfig = ConfigurationManager.getWebConfig();
    public static AuthSelenoidConfig authSelenoidConfig = ConfigurationManager.getAuthSelenoidConfig();

    public void config() {
        Configuration.baseUrl = webConfig.baseUrl();
        String[] browserWithVersion = webConfig.getBrowserAndVersion();
        Configuration.browser = browserWithVersion[0];
        Configuration.browserVersion = browserWithVersion[1];
        Configuration.browserSize = webConfig.browserSize();

        String remoteUrl = webConfig.remoteUrl();
        if (remoteUrl != null)
            selenoidVideo();
    }

    public void selenoidVideo() {
        String remoteUrl = webConfig.remoteUrl();
        Configuration.remote = "https://" + authSelenoidConfig.remote_username() + ":" + authSelenoidConfig.remote_password() + "@" + remoteUrl  + "/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
}