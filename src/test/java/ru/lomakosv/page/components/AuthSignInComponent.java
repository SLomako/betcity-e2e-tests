package ru.lomakosv.page.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AuthSignInComponent {

    private final SelenideElement
            SIGN_IN_BUTTON = $("#authSignIn"),
            LOGIN_INPUT = $("[name='login']"),
            PASS_INPUT = $("[name='pass']"),
            LOGIN_SIGN_IN_BUTTON = $("#loginBtnSignIn");

    private final ElementsCollection
            AUTH_BUTTON = $$(".login__tabs-item");

    public void logInWithPhoneNumber(String accountPhone, String password) {
        step("Нажимаем кнопку вход на главном меню", () ->
                SIGN_IN_BUTTON.shouldBe(visible).click());

        step("Выбираем вкладку телефон", () ->
                AUTH_BUTTON.get(0).click());

        step("Вводим номер телефона", () ->
                LOGIN_INPUT.shouldBe(visible).setValue(accountPhone));

        step("Вводим пароль", () ->
                PASS_INPUT.shouldBe(visible).setValue(password));

        step("Нажимаем войти", () ->
                LOGIN_SIGN_IN_BUTTON.shouldBe(visible).click());
    }

    public void logInByAccountNumber(String accountNumber, String password) {
        step("Нажимаем кнопку вход на главном меню", () ->
                SIGN_IN_BUTTON.shouldBe(visible).click());

        step("Выбираем вкладу счет", () ->
                AUTH_BUTTON.get(2).click());

        step("Вводим номер счета", () ->
                LOGIN_INPUT.shouldBe(visible).setValue(accountNumber));

        step("Вводим пароль", () ->
                PASS_INPUT.shouldBe(visible).setValue(password));

        step("Нажимаем войти", () ->
                LOGIN_SIGN_IN_BUTTON.shouldBe(visible).click());
    }
}
