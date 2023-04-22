package ru.lomakosv.page.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class UserInfoComponent {

    String fff = "15821548";
    private final SelenideElement
            VERIFICATION_NAME_LOGIN = $("[class='user-info__item-step-value']"),
            LOG_OUT_BUTTON = $("[class*=icon_logout-light]");

    public void verifyLogin() {
        step("Проверка номера счета", () -> {
            VERIFICATION_NAME_LOGIN.shouldHave(Condition.text(fff));
        });}

    public void logOut() {
        step("Выходим из аккаунта", () -> {
            LOG_OUT_BUTTON.shouldBe(enabled).click();
        });
    }
}
