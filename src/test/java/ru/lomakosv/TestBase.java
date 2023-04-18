package ru.lomakosv;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.lomakosv.config.ConfigReader;
import ru.lomakosv.config.ProjectConfiguration;
import ru.lomakosv.config.WebConfig;
import ru.lomakosv.helpers.Attach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    private static final WebConfig config = ConfigReader.Instance.read();

    @BeforeAll
    static void BeforeALl() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(config);
        projectConfiguration.webConfig();
    }

    @BeforeEach
    void beforeEach() {
        open(config.baseUrl());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
