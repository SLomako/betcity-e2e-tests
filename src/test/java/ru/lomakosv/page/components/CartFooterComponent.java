package ru.lomakosv.page.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartFooterComponent {

    private final SelenideElement
            MESSAGE = $("[class='cart-footer__highlighted-holder']"),
            CLEAR_BUTTON = $("[id=cartTopClearButton]"),
            SIMPLE_BET_BUTTON = $("[id=cartTabSingle]"),
            AMOUNT_INPUT = $("[class='input'] :nth-child(1)"),
            CONFIRM_BUTTON = $("[id='cartButtonCheckout']");

    public void verifyMessage(String verifyStr) {
        MESSAGE.shouldHave(Condition.text(verifyStr));
        CLEAR_BUTTON.click();
    }

    public CartFooterComponent selectSimpleBetting() {
        SIMPLE_BET_BUTTON.click();
        return this;
    }

    public CartFooterComponent depositTheAmount(String amount) {
        AMOUNT_INPUT.setValue(amount);
        return this;
    }

    public CartFooterComponent confirmBet() {
        CONFIRM_BUTTON.click();
        return this;
    }
}