package ru.lomakosv.page.components;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class UserInfoComponent {


    private final SelenideElement
            VERIFICATION_NAME_LOGIN = $("[class='user-info__item-step-value']"),
            LOG_OUT_BUTTON = $("[class*=icon_logout-light]");

    public void getNumberLogin(String accountNumber) {
        step("Проверка номера счета", () ->
                VERIFICATION_NAME_LOGIN.shouldHave(text(accountNumber)));
    }

    public void logOut() {
        step("Выходим из аккаунта", () ->
                LOG_OUT_BUTTON.shouldBe(enabled).shouldBe(visible).click());
    }

}
