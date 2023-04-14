package ru.lomakosv.page.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AuthSignInComponent {


    public void phoneEntry() {

        $("#authSignIn").click();
        $("[name='login']").setValue("9254970519");
        $("[name='pass']").setValue("qwerasdfzxcv");
        $("#loginBtnSignIn").click();
    }

    public void acctNumberEntry() {

        $("#authSignIn").click();
        $$(".login__tabs-item").get(2).click();
        $("[name='login']").setValue("15821548");
        $("[name='pass']").setValue("qwerasdfzxcv");
        $("#loginBtnSignIn").click();
    }
}
