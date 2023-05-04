package ru.lomakosv.page.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

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
        step("Проверка сообщения", () -> {
            MESSAGE.shouldHave(Condition.text(verifyStr));
            CLEAR_BUTTON.click();
        });
    }

    public void selectSimpleBetting() {
        step("Выбираем 'Одиночную' ставку", () -> {
            SIMPLE_BET_BUTTON.click();
        });
    }

    public void selectExpressBetting() {
        step("Выбираем 'Экспресс' ставку", () -> {
            EXPRESS_BET_BUTTON.click();
        });
    }

    public void selectSystemBetting() {
        step("Выбираем 'Система' ставок", () -> {
            SYSTEM_BET_BUTTON.click();
        });
    }

    public CartFooterComponent depositTheAmount(String amount) {
        step("Вносим сумму ставки", () -> {
            AMOUNT_INPUT.setValue(amount);
        });
        return this;
    }

    public void confirmBet() {
        step("Нажимаем кнопку 'Заключить Пари'", () -> {
            CONFIRM_BUTTON.click();
        });
    }
}