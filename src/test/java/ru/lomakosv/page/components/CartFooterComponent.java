package ru.lomakosv.page.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
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

    public void getMessage(String verifyStr) {
        step("Проверка сообщения", () -> {
            MESSAGE.shouldHave(Condition.text(verifyStr));
            CLEAR_BUTTON.shouldBe(visible).click();
        });
    }

    public void selectSimpleBetting() {
        step("Выбираем раздел'Одиночную' в ставках", () ->
                SIMPLE_BET_BUTTON.shouldBe(visible).click());
    }

    public void selectExpressBetting() {
        step("Выбираем раздел 'Экспресс' в ставках", () ->
                EXPRESS_BET_BUTTON.shouldBe(visible).click());
    }

    public void selectSystemBetting() {
        step("Выбираем раздел 'Система' в ставках", () ->
                SYSTEM_BET_BUTTON.shouldBe(visible).click());
    }

    public CartFooterComponent setBetAmount(String amount) {
        step(String.format("сумма ставки %s", amount), () ->
                AMOUNT_INPUT.setValue(amount));

        return this;
    }

    public void clickPlaceBetButton() {
        step("Нажимаем кнопку 'Заключить Пари'", () ->
                CONFIRM_BUTTON.shouldBe(visible).click());
    }
}