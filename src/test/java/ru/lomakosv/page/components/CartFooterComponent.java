package ru.lomakosv.page.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartFooterComponent {

    private final SelenideElement MESSAGE = $("[class='cart-footer__highlighted-holder']");

    public void verifyMessage(String verifyStr) {

        MESSAGE.shouldHave(Condition.text(verifyStr));
        $("[id=cartTopClearButton]").click();


    }
}
