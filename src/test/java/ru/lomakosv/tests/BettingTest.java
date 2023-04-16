package ru.lomakosv.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lomakosv.Betting;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.BettingPage;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.CartFooterComponent;
import ru.lomakosv.page.components.PopularsHeaderComponent;

import static com.codeborne.selenide.Selenide.$;


@DisplayName("Тест одиночного пари")
@Tag("remote")
public class BettingTest extends TestBase {

    CartFooterComponent cartFooterComponent = new CartFooterComponent();
    AuthSignInComponent authSignInComponent = new AuthSignInComponent();
    PopularsHeaderComponent popularsHeaderComponent = new PopularsHeaderComponent();
    BettingPage bettingPage = new BettingPage();


    @DisplayName("собите")
    @Test
    void testSimpleBetting() {

        authSignInComponent.accountNumberEntry();

        popularsHeaderComponent.openPopularsChamps();

        bettingPage.selectBettingOption(Betting.SIMPLE);

        cartFooterComponent.selectSimpleBetting()
                .depositTheAmount("1000")
                .confirmBet()
                .verifyMessage("Пари не оформлено. Недостаточно средств на счете");

    }
}

