package ru.lomakosv.page.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UserInfoComponent {

    private final SelenideElement
            VERIFICATION_NAME_LOGIN = $("[class='user-info__item-step-value']");


    public void verifyLogin() {
        VERIFICATION_NAME_LOGIN.shouldHave(Condition.text("15821548"));
    }
}
