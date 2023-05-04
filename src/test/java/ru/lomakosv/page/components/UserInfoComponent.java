package ru.lomakosv.page.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.lomakosv.config.AuthAccountNumberConfig;
import ru.lomakosv.config.ConfigurationManager;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class UserInfoComponent {

    private final AuthAccountNumberConfig authAccountNumberConfig  = ConfigurationManager.getAuthAccountNumberConfig();

    private final SelenideElement
            VERIFICATION_NAME_LOGIN = $("[class='user-info__item-step-value']"),
            LOG_OUT_BUTTON = $("[class*=icon_logout-light]");

    public void checkLogin()  {
        step("Проверка номера счета", () -> {
            VERIFICATION_NAME_LOGIN.shouldHave(Condition.text(authAccountNumberConfig.accountNumber()));
        });
    }

    public void logOut() {
        step("Выходим из аккаунта", () -> {
            LOG_OUT_BUTTON.shouldBe(enabled).click();
        });
    }

}
