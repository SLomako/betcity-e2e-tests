package ru.lomakosv.page.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.lomakosv.config.AuthAccountNumberConfig;
import ru.lomakosv.config.AuthAccountPhoneConfig;
import ru.lomakosv.config.ConfigurationManager;

import java.io.IOException;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AuthSignInComponent {

    public static AuthAccountNumberConfig authAccountNumberConfig = ConfigurationManager.getAuthAccountNumberConfig();
    public static AuthAccountPhoneConfig authAccountPhoneConfig = ConfigurationManager.getAuthAccountPhoneConfig();

    static final SelenideElement
            SIGN_IN_BUTTON = $("#authSignIn"),
            LOGIN_INPUT = $("[name='login']"),
            PASS_INPUT = $("[name='pass']"),
            LOGIN_SIGN_IN_BUTTON = $("#loginBtnSignIn");

    static final ElementsCollection
            AUTH_PHONE_BUTTON = $$(".login__tabs-item"),
            AUTH_ACCOUNT_NUMBER = $$(".login__tabs-item");

    public void accountPhoneEntry() {

        step("Нажимаем кнопку вход на главном меню", () -> {
            SIGN_IN_BUTTON.click();
        });

        step("Выбираем вход по телефону", () -> {
            AUTH_PHONE_BUTTON.get(0).click();
        });

        step("Вводим номер телефона", () -> {
            LOGIN_INPUT.setValue(authAccountPhoneConfig.accountPhone());
        });

        step("Вводим пароль", () -> {
            PASS_INPUT.setValue(authAccountPhoneConfig.password());
        });

        step("Нажимаем войти", () -> {
            LOGIN_SIGN_IN_BUTTON.click();
        });
    }

    public void accountNumberEntry() {

        step("Нажимаем кнопку вход на главном меню", () -> {
            SIGN_IN_BUTTON.click();
        });

        step("Выбираем вход по номеру аккаунта", () -> {
            AUTH_ACCOUNT_NUMBER.get(2).click();
        });

        step("Вводим номер аккаунта", () -> {
            LOGIN_INPUT.setValue(authAccountNumberConfig.accountNumber());
        });

        step("Вводим пароль", () -> {
            PASS_INPUT.setValue(authAccountNumberConfig.password());
        });

        step("Нажимаем войти", () -> {
            LOGIN_SIGN_IN_BUTTON.click();
        });
    }
}
