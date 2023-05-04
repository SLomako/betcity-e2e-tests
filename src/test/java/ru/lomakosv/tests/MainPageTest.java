package ru.lomakosv.tests;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.lomakosv.TestBase;
import ru.lomakosv.data.MenuItems;
import ru.lomakosv.utils.Critical;
import ru.lomakosv.utils.Minor;

import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("SLomako")
@DisplayName("Тесты на главную страницу")
public class MainPageTest extends TestBase {

    @EnumSource(value = MenuItems.class)
    @DisplayName("Параметризированный")
    @ParameterizedTest(name = "В первом результате выдачи для {0} должен отображаться текст {1}")
    void testMenuDependingOnTheLocal(MenuItems menuItems) {

        Locale locale = menuItems.getLocale();
        List<String> expectedMenuNames = menuItems.getMenuNames();

        step("Нажимаем на значек смену языка", () -> {
            $("[class='custom-select menu-lang']").click();
        });
        step("Выбираем язык для сайта", () -> {
            $$("[class='custom-select-popup-item__text']").find(text(String.valueOf(locale))).click();
        });
        step("Проверка изменения наименований меню согласно выбраному языку", () -> {
            $$("[class='menu'] a").filter(visible).shouldHave(CollectionCondition.texts(expectedMenuNames));
        });
    }


    @Critical
    @DisplayName("Проверка содержания заголовка главной страницы")
    @Test
    void testHeadTitle() {
        step("Проверяем полное содержания строки 'Ставки на спорт онлайн в букмекерской конторе — БЕТСИТИ'", () -> {
            String title = $("head > title").innerText();
            Assertions.assertEquals(title, "Ставки на спорт онлайн в букмекерской конторе — БЕТСИТИ");
        });
    }

    @Minor
    @DisplayName("Проверка наличия ссылки на телеграмм бот")
    @Test
    void testLinkTelegramSupportBot() {
        step("Проверяем наличие ссылки на телеграмм бота https://t.me/betcityru_support_bot", () -> {
            String linkTelegramSupportBot = $("[class=right-block-support__item] " +
                    "[href='https://t.me/betcityru_support_bot']").getAttribute("href");
            Assertions.assertEquals(linkTelegramSupportBot, "https://t.me/betcityru_support_bot");
        });
    }

    @Minor
    @DisplayName("Проверка номера телефона Технической поддержки ")
    @Test
    void testLinkLiveChat() {
        step("Проверяем тел. '8 800 100 74 75'", () -> {
            String title = $("[class=right-block-support__tel]").innerText();
            Assertions.assertEquals(title, "8 800 100 74 75");
        });
    }
}


