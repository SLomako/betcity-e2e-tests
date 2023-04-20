package ru.lomakosv.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.lomakosv.enums.Betting;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.BettingPage;
import ru.lomakosv.page.AuthSignInPage;
import ru.lomakosv.page.components.CartFooterComponent;
import ru.lomakosv.page.components.PopularsHeaderComponent;
import ru.lomakosv.utils.Critical;


@Critical
@DisplayName("Тест на заключение пари при неодостаточном балансе на счету")
@Tag("remote")
public class BettingTest extends TestBase {

    CartFooterComponent cartFooterComponent = new CartFooterComponent();
    AuthSignInPage authSignInComponent = new AuthSignInPage();
    PopularsHeaderComponent popularsHeaderComponent = new PopularsHeaderComponent();
    BettingPage bettingPage = new BettingPage();

    @DisplayName("Тест")
    @EnumSource(Betting.class)
    @ParameterizedTest (name = "для {0}")
    void testBetting(Betting bettingOption) {

        authSignInComponent.accountNumberEntry();

        popularsHeaderComponent.openPopularsChamps();

        bettingPage.selectBettingOption(bettingOption.name());

        cartFooterComponent
                .depositTheAmount("1000")
                .confirmBet()
                .verifyMessage("Пари не оформлено. Недостаточно средств на счете");

    }
}

