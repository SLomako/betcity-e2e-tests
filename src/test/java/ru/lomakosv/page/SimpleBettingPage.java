package ru.lomakosv.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SimpleBettingPage {

    private final SelenideElement
            AMOUNTINPUT = $("[class='input'] :nth-child(1)");

    public SimpleBettingPage openPopularsChamps() {
        $("[class*='left-filter__list populars__champs'] :first-child").click();
        return this;
    }

    public SimpleBettingPage chooseBetOneEvent() {
        $$("[class='line-event__main-bets'] :nth-child(1)").get(0).click();
        return this;

    }

    public SimpleBettingPage chooseSimpleBetting() {
        $("[id=cartTabExpress]").click();
        return this;
    }

    public SimpleBettingPage depositTheAmount(String ammount) {
        AMOUNTINPUT.setValue(ammount);
        return this;
    }

    public void confirmBet() {
        $("[id='cartButtonCheckout']").click();

    }
}
