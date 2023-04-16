package ru.lomakosv.page;

import com.codeborne.selenide.ElementsCollection;
import ru.lomakosv.Betting;
import ru.lomakosv.page.components.CartFooterComponent;

import static com.codeborne.selenide.Selenide.$$;

public class BettingPage {

    CartFooterComponent cartFooterComponent = new CartFooterComponent();
    private final ElementsCollection
            SELECT_COUNT_BETTING = $$("[class='line-event__main-bets'] :nth-child(1)");


    public void selectBettingOption(String bettingOption) {
        if (Betting.SIMPLE.name().equals(bettingOption)) {
            SELECT_COUNT_BETTING.get(0).click();
            cartFooterComponent.selectSimpleBetting();
        }
        else if (Betting.SYSTEM.name().equals(bettingOption)) {
            SELECT_COUNT_BETTING.get(0).click();
            SELECT_COUNT_BETTING.get(1).click();
            cartFooterComponent.selectSystemBetting();
        }

        else if (Betting.EXPRESS.name().equals(bettingOption)) {
            SELECT_COUNT_BETTING.get(0).click();
            SELECT_COUNT_BETTING.get(1).click();
            SELECT_COUNT_BETTING.get(2).click();
            cartFooterComponent.selectExpressBetting();
        }
        else System.out.println("нет такого варианта ставки");
    }
}
