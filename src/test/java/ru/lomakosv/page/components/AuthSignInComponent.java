package ru.lomakosv.page.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AuthSignInComponent {

    static final SelenideElement
            SIGN_IN_BUTTON = $("#authSignIn"),
            LOGIN_INPUT = $("[name='login']"),
            PASS_INPUT = $("[name='pass']"),
            LOGIN_SIGN_IN_BUTTON = $("#loginBtnSignIn");

    static final ElementsCollection
            AUTH_PHONE_BUTTON = $$(".login__tabs-item"),
            AUTH_ACCOUNT_NUMBER =  $$(".login__tabs-item");



    public void phoneEntry() {

        SIGN_IN_BUTTON.click();
        AUTH_PHONE_BUTTON.get(0).click();
        LOGIN_INPUT.setValue("9254970519");
        PASS_INPUT.setValue("qwerasdfzxcv");
        LOGIN_SIGN_IN_BUTTON.click();
    }

    public void accountNumberEntry() {

        SIGN_IN_BUTTON.click();
        AUTH_ACCOUNT_NUMBER.get(2).click();
        LOGIN_INPUT.setValue("15821548");
        PASS_INPUT.setValue("qwerasdfzxcv");
        LOGIN_SIGN_IN_BUTTON.click();
    }

}
