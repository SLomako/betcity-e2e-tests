package ru.lomakosv.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Locale;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPage {

    private final SelenideElement LANGUAGE_BUTTON = $("[class='custom-select menu-lang']"),
            PAGE_TITLE = $("head > title"),
            TELEGRAM_BOT_LINK_ELEMENT = $("[class=right-block-support__item] " +
                    String.format("[href='%s']", "https://t.me/betcityru_support_bot")),
            SUPPORT_PHONE_NUMBER = $("[class=right-block-support__tel]"),
            POPUP_CLOSE_BUTTON = $("[class='icon icon_close']"),
            POPUP_TITLE = $x("//app-push-confirm-form/div[2]/h3");

    private final ElementsCollection LANGUAGE_SELECTION_BUTTON = $$("[class='custom-select-popup-item__text']"),
            MENU_TITLE_ELEMENTS = $$("[class='menu'] a").filter(visible);

    public void clickLanguageIcon() {
        LANGUAGE_BUTTON.shouldBe(visible).click();
    }

    public void selectLanguage(Locale locale) {
        LANGUAGE_SELECTION_BUTTON.find(text(String.valueOf(locale))).shouldBe(visible).click();
    }

    public ElementsCollection getMenuItems() {
        return MENU_TITLE_ELEMENTS;
    }

    public String getFullStringPresence() {
        return PAGE_TITLE.innerText();
    }

    public String getTelegramBotLinkPresence() {
        return TELEGRAM_BOT_LINK_ELEMENT.getAttribute("href");
    }

    public String getDisplayedPhoneNumber() {
        return SUPPORT_PHONE_NUMBER.innerText();
    }

    public void closePopup(String popupTitle) {
        step("Закрытие всплывающего окна с текстом 'Уведомления от БЕТСИТИ", () -> {
            String POPUP = POPUP_TITLE.getText();
            if (Objects.equals(POPUP, popupTitle)) {
                POPUP_CLOSE_BUTTON.click();
            }
        });
    }
}
