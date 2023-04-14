package ru.lomakosv.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ExpressBettingPage {
    private final SelenideElement
    AMOUNTINPUT = $("[class='input'] :nth-child(1)");


    public ExpressBettingPage openPopularsChamps() {
        $("[class*='left-filter__list populars__champs'] :first-child").click();
        return this;
    }

    public ExpressBettingPage chooseBetTwoEvent() {
        $$("[class='line-event__main-bets'] :nth-child(1)").get(0).click();
        $$("[class='line-event__main-bets'] :nth-child(1)").get(1).click();
        return this;
    }

    public ExpressBettingPage chooseExpressBetting() {
        $("[id=cartTabExpress]").click();
        return this;
    }

    public ExpressBettingPage depositTheAmount(String amount) {
        AMOUNTINPUT.setValue(amount);
        return this;
    }

    public void confirmBet() {
        $("[id='cartButtonCheckout']").click();
    }
}
