package ru.lomakosv;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Link;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.lomakosv.config.ProjectConfiguration;
import ru.lomakosv.helpers.Attach;

import static ru.lomakosv.config.ProjectConfiguration.webConfig;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    static ProjectConfiguration projectConfiguration = new ProjectConfiguration();

    @Link("https://betcity.ru")
    @BeforeAll
    static void BeforeALl() {
        projectConfiguration.config();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void beforeEach() {
        open(webConfig.baseUrl());
    }

    @AfterEach
    void addAttachments() {
        if (webConfig.isRemote()) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
    }
}
