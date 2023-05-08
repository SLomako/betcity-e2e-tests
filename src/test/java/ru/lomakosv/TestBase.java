package ru.lomakosv;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.lomakosv.config.ProjectConfiguration;
import ru.lomakosv.helpers.Attach;
import ru.lomakosv.page.MainPage;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;

public class TestBase {

    static ProjectConfiguration projectConfiguration = new ProjectConfiguration();

    @BeforeAll
    static void setupTestEnvironment() {
        projectConfiguration.config();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void openMainPage() {
        step("Открываем главную страницу", () ->
                open(baseUrl));

        step("Закрытие всплывающего окна с текстом 'Уведомления от БЕТСИТИ", () -> {
            MainPage mainPage = new MainPage();
            mainPage.closePopup("Уведомления от БЕТСИТИ");
        });
    }

    @AfterEach
    void addAttachmentsAndCloseMainPage() {
        Attach.addVideo();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.screenshotAs("Last screenshot");
        step("Закрываем вкладку браузера", () ->
                switchTo().window(getWebDriver().getWindowHandle()).close());

    }
}