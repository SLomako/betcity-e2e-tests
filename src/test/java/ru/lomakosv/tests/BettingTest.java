package ru.lomakosv.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.lomakosv.config.AuthAccountPhoneConfig;
import ru.lomakosv.config.ConfigurationManager;
import ru.lomakosv.data.Betting;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.BettingPage;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.CartFooterComponent;
import ru.lomakosv.page.components.PopularsHeaderComponent;
import ru.lomakosv.page.components.UserInfoComponent;
import ru.lomakosv.utils.Critical;

import static io.qameta.allure.Allure.step;

@Owner("SLomako")
@Critical
@DisplayName("Тест на заключение пари при недостаточном балансе на счету")

public class BettingTest extends TestBase {

    private final AuthSignInComponent authSignInComponent = new AuthSignInComponent();
    private final AuthAccountPhoneConfig authAccountPhoneConfig = ConfigurationManager.getAuthAccountPhoneConfig();
    private final CartFooterComponent cartFooterComponent = new CartFooterComponent();
    private final PopularsHeaderComponent popularsHeaderComponent = new PopularsHeaderComponent();
    private final UserInfoComponent userInfoComponent = new UserInfoComponent();
    private final BettingPage bettingPage = new BettingPage();

    @DisplayName("Тест на заключение пари при недостаточном балансе на счету")
    @EnumSource(Betting.class)
    @ParameterizedTest(name = "для {0}")
    void testBetting(Betting bettingOption) {
        step("Входим по номеру телефона", () -> {
            authSignInComponent.logInWithPhoneNumber(authAccountPhoneConfig.accountPhone(), authAccountPhoneConfig.password());
        });
        step("Открываем Топ матчи в разделе популярное", popularsHeaderComponent::openPopularsChamps);

        step("Выбираем систему ставок {0}", () -> {
            bettingPage.selectBettingOption(bettingOption.name());
        });
        step("Вводим сумму ставки", () -> {
            cartFooterComponent
                    .depositTheAmount("1000")
                    .confirmBet();
        });
        step("Проверка сообщения о результате заключения пари", () -> {
            cartFooterComponent.verifyMessage("Пари не оформлено. Недостаточно средств на счете");
        });
        step("Выход из аккаунта", userInfoComponent::logOut);
    }
}

