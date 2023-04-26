package ru.lomakosv.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import ru.lomakosv.TestBase;
import ru.lomakosv.utils.Critical;
import ru.lomakosv.utils.Minor;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Owner("SLomako")
@DisplayName("Тесты на главную страницу")
public class MainPageTest extends TestBase {


    @Critical
    @Tags({@Tag("web"), @Tag("critical")})
    @DisplayName("Проверка содержания заголовка главной страницы")
    @Test
    void testHeadTitle() {

        step("Проверяем полное содержания строки 'Ставки на спорт онлайн в букмекерской конторе — БЕТСИТИ'", () -> {
            String title = $("head > title").innerText();
            Assertions.assertEquals(title, "Ставки на спорт онлайн в букмекерской конторе — БЕТСИТИ");
        });
    }

    @Minor
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Проверка налчие ссылки на телеграмм бот")
    @Test
    void testLinkTelegramSupportBot() {

        step("Проверяем наличие ссылки на телеграмм бота https://t.me/betcityru_support_bot", () -> {
            String linkTelegramSupportBot = $("[class=right-block-support__item] [href='https://t.me/betcityru_support_bot']").getAttribute("href");
            Assertions.assertEquals(linkTelegramSupportBot, "https://t.me/betcityru_support_bot");
        });
    }

    @Minor
    @Disabled
    @Tags({@Tag("web"), @Tag("minor")})
    @DisplayName("Проверка номера телефона Технической поддержки ")
    @Test
    void testLinkLiveChat() {

        step("Проверяем тел. '8 800 100 74 75'", () -> {
            String title = $("[class=right-block-support__tel]").innerText();
            Assertions.assertEquals(title, "8 800 100 74 75");
        });



    }
}


