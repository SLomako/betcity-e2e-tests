package ru.lomakosv.tests;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.lomakosv.TestBase;
import ru.lomakosv.data.MenuItems;
import ru.lomakosv.page.MainPage;
import ru.lomakosv.helpers.annotanion.Critical;
import ru.lomakosv.helpers.annotanion.Minor;

import java.util.List;
import java.util.Locale;

import static io.qameta.allure.Allure.step;

@Owner("SLomako")
@DisplayName("Тесты главной страницы")
public class MainPageTest extends TestBase {

    private final MainPage mainPage = new MainPage();

    @EnumSource(value = MenuItems.class)
    @ParameterizedTest(name = "Проверка отображения текста в выдаче для {0}")
    @DisplayName("Тест проверки меню в зависимости от локали")
    void testMenuDependingOnTheLocal(MenuItems menuItems) {

        Locale locale = menuItems.getLocale();
        List<String> expectedMenuNames = menuItems.getMenuNames();

        step(" Нажимаем на иконку смены языка", () ->
            mainPage.clickLanguageIcon());
        step(" Выбираем язык для отображения на сайте", () ->
            mainPage.selectLanguage(locale));
        step("Проверяем изменение названий меню в соответствии с выбранным языком", () ->
            mainPage.getMenuItems().shouldHave(CollectionCondition.texts(expectedMenuNames)));
    }

    @Critical
    @Test
    @DisplayName("Проверка соответствия заголовка главной страницы заданному тексту")
    void testHeadTitle() {
        step("Проверяем наличие полной строки", () ->
            Assertions.assertEquals(mainPage.getFullStringPresence(), "Ставки на спорт онлайн в букмекерской конторе — БЕТСИТИ"));
    }

    @Minor
    @Test
    @DisplayName("Проверка наличия ссылки на Telegram-бот в правом нижнем углу")
    void testLinkTelegramSupportBot() {
        step("Проверяем наличие ссылки на Telegram-бота https://t.me/betcityru_support_bot", () ->
            Assertions.assertEquals(mainPage.getTelegramBotLinkPresence(), "https://t.me/betcityru_support_bot"));
    }

    @Minor
    @Test
    @DisplayName("Проверка корректность номера телефона технической поддержки в правом нижнем углу")
    void testLinkLiveChat() {
        step("Проверяем, что телефонный номер отображается корректно", () ->
            Assertions.assertEquals(mainPage.getDisplayedPhoneNumber(), "8 800 100 74 75"));
    }
}


