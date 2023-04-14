package ru.lomakosv.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SystemBettingPage {


    private final SelenideElement
            AMOUNTINPUT = $("[class='input'] :nth-child(1)");


    public SystemBettingPage openPopularsChamps() {
        $("[class*='left-filter__list populars__champs'] :first-child").click();
        return this;
    }

    public SystemBettingPage chooseBetThreeEvent() {
        $$("[class='line-event__main-bets'] :nth-child(1)").get(0).click();
        $$("[class='line-event__main-bets'] :nth-child(1)").get(1).click();
        $$("[class='line-event__main-bets'] :nth-child(1)").get(2).click();
        return this;
    }

    public SystemBettingPage chooseSystemBetting() {
        $("[id=cartTabSystem]").click();
        return this;
    }

    public SystemBettingPage depositTheAmount(String amount) {
        AMOUNTINPUT.setValue(amount);
        return this;
    }

    public void confirmBet() {
        $("[id='cartButtonCheckout']").click();

    }

}
