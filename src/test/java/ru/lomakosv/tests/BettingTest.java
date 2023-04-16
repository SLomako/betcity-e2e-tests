package ru.lomakosv.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.lomakosv.Betting;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.BettingPage;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.CartFooterComponent;
import ru.lomakosv.page.components.PopularsHeaderComponent;

@DisplayName("Тест пари")
@Tag("remote")
public class BettingTest extends TestBase {

    CartFooterComponent cartFooterComponent = new CartFooterComponent();
    AuthSignInComponent authSignInComponent = new AuthSignInComponent();
    PopularsHeaderComponent popularsHeaderComponent = new PopularsHeaderComponent();
    BettingPage bettingPage = new BettingPage();


    @EnumSource(Betting.class)
    @ParameterizedTest (name = "для {0}")
    void testSimpleBetting(Betting bettingOption) {

        authSignInComponent.accountNumberEntry();

        popularsHeaderComponent.openPopularsChamps();

        bettingPage.selectBettingOption(bettingOption.name());

        cartFooterComponent
                .depositTheAmount("1000")
                .confirmBet()
                .verifyMessage("Пари не оформлено. Недостаточно средств на счете");

    }
}

