package ru.lomakosv.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfiguration {

    protected static WebConfig webConfig = ConfigurationManager.getWebConfig();
    protected static SelenoidConfig authSelenoidConfig = ConfigurationManager.getAuthSelenoidConfig();

    public void config() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = webConfig.baseUrl();
        String[] browserWithVersion = webConfig.browserAndVersion();
        Configuration.browser = browserWithVersion[0];
        Configuration.browserVersion = browserWithVersion[1];
        Configuration.browserSize = webConfig.browserSize();

        String remoteUrl = webConfig.url();
        if (remoteUrl != null)
            selenoidVideo();
    }

    public void selenoidVideo() {
        String remoteUrl = webConfig.url();
        Configuration.remote = "https://" + authSelenoidConfig.userName() + ":" + authSelenoidConfig.password() + "@" + remoteUrl  + "/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
}