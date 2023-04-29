package ru.lomakosv.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.lomakosv.enums.Betting;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.BettingPage;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.CartFooterComponent;
import ru.lomakosv.page.components.PopularsHeaderComponent;
import ru.lomakosv.page.components.UserInfoComponent;
import ru.lomakosv.utils.Critical;

@Owner("SLomako")
@Critical
@DisplayName("Тест на заключение пари при недостаточном балансе на счету")

public class BettingTest extends TestBase {

    CartFooterComponent cartFooterComponent = new CartFooterComponent();
    AuthSignInComponent authSignInComponent = new AuthSignInComponent();
    PopularsHeaderComponent popularsHeaderComponent = new PopularsHeaderComponent();
    UserInfoComponent userInfoComponent = new UserInfoComponent();
    BettingPage bettingPage = new BettingPage();


    @Tags({@Tag("web"), @Tag("critical"), @Tag("auth")})
    @DisplayName("Тест")
    @EnumSource(Betting.class)
    @ParameterizedTest(name = "{displayName} [{argumentsWithNames}]")
    void testBetting(Betting bettingOption) {

        authSignInComponent.accountNumberEntry();

        popularsHeaderComponent.openPopularsChamps();

        bettingPage.selectBettingOption(bettingOption.name());

        cartFooterComponent
                .depositTheAmount("1000")
                .confirmBet()
                .verifyMessage("Пари не оформлено. Недостаточно средств на счете");

        userInfoComponent.logOut();
    }
}

