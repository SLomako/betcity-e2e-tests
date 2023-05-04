package ru.lomakosv.page.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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
        step("Нажимаем кнопку вход на главном меню", () -> {
            SIGN_IN_BUTTON.click();
        });
        step("Выбираем вход по телефону", () -> {
            AUTH_BUTTON.get(0).click();
        });
        step("Вводим номер телефона", () -> {
            LOGIN_INPUT.setValue(accountPhone);
        });
        step("Вводим пароль", () -> {
            PASS_INPUT.setValue(password);
        });
        step("Нажимаем войти", () -> {
            LOGIN_SIGN_IN_BUTTON.click();
        });
    }

    public void logInByAccountNumber(String accountNumber, String password) {
        step("Нажимаем кнопку вход на главном меню", () -> {
            SIGN_IN_BUTTON.click();
        });
        step("Выбираем вход по номеру аккаунта", () -> {
            AUTH_BUTTON.get(2).click();
        });
        step("Вводим номер аккаунта", () -> {
            LOGIN_INPUT.setValue(accountNumber);
        });
        step("Вводим пароль", () -> {
            PASS_INPUT.setValue(password);
        });
        step("Нажимаем войти", () -> {
            LOGIN_SIGN_IN_BUTTON.click();
        });
    }
}
