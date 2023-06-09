package ru.lomakosv.page;

import com.codeborne.selenide.ElementsCollection;
import ru.lomakosv.data.Betting;
import ru.lomakosv.page.components.CartFooterComponent;

import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class BettingPage {

    private final CartFooterComponent cartFooterComponent = new CartFooterComponent();
    private final ElementsCollection
            SELECT_COUNT_BETTING = $$("[class='line-event__main-bets'] :nth-child(1)");

    public void selectBettingOption(String bettingOption) {

        if (Betting.SIMPLE.name().equals(bettingOption)) {
            step("Выбираем победу первой команды в списке", () -> {
                SELECT_COUNT_BETTING.get(0).click();
                cartFooterComponent.selectSimpleBetting();
            });
        }
        if (Betting.SYSTEM.name().equals(bettingOption)) {
            step("Выбираем победу первых трёх команд в списке", () -> {
                SELECT_COUNT_BETTING.get(0).click();
                SELECT_COUNT_BETTING.get(1).click();
                SELECT_COUNT_BETTING.get(2).click();
                cartFooterComponent.selectSystemBetting();
            });
        } else if (Betting.EXPRESS.name().equals(bettingOption)) {
            step("Выбираем победу первых двух команд в списке", () -> {
                SELECT_COUNT_BETTING.get(0).click();
                SELECT_COUNT_BETTING.get(1).click();
                cartFooterComponent.selectExpressBetting();
            });
        }
    }
}
