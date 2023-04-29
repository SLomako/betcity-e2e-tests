package ru.lomakosv;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.lomakosv.config.ProjectConfiguration;
import ru.lomakosv.helpers.Attach;

import static com.codeborne.selenide.Configuration.baseUrl;
import static io.qameta.allure.Allure.step;
import static ru.lomakosv.config.ProjectConfiguration.webConfig;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    static ProjectConfiguration projectConfiguration = new ProjectConfiguration();

    @BeforeAll
    static void BeforeALl() {
        projectConfiguration.config();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void beforeEach() {
        step("Открываем главную страницу", () -> {
            open(baseUrl);
        });
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
