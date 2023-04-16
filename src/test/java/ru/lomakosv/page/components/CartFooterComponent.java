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
            CONFIRM_BUTTON = $("[id='cartButtonCheckout']"),
            EXPRESS_BET_BUTTON = $("[id=cartTabExpress]"),
            SYSTEM_BET_BUTTON = $("[id=cartTabSystem]");

    public void verifyMessage(String verifyStr) {
        MESSAGE.shouldHave(Condition.text(verifyStr));
        CLEAR_BUTTON.click();
    }

    public void selectSimpleBetting() {
        SIMPLE_BET_BUTTON.click();
    }

    public void selectExpressBetting() {
        EXPRESS_BET_BUTTON.click();
    }

    public void selectSystemBetting() {
        SYSTEM_BET_BUTTON.click();
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