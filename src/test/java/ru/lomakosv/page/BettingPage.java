package ru.lomakosv.page;

import com.codeborne.selenide.ElementsCollection;
import ru.lomakosv.Betting;

import static com.codeborne.selenide.Selenide.$$;

public class BettingPage {

    private final ElementsCollection
            SELECT_COUNT_BETTING = $$("[class='line-event__main-bets'] :nth-child(1)");


    public void selectBettingOption(Betting bettingOption) {
        if (Betting.SIMPLE == bettingOption) {
            SELECT_COUNT_BETTING.get(0).click();
        }
        else if (Betting.SYSTEM == bettingOption) {
            SELECT_COUNT_BETTING.get(0).click();
            SELECT_COUNT_BETTING.get(1).click();
        }

        else if (Betting.EXPRESS == bettingOption) {
            SELECT_COUNT_BETTING.get(0).click();
            SELECT_COUNT_BETTING.get(1).click();
            SELECT_COUNT_BETTING.get(2).click();
        }
        else System.out.println("нет такого варианта ставки");
    }
}
