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
import ru.lomakosv.helpers.annotanion.Critical;

import static io.qameta.allure.Allure.step;

@Owner("SLomako")
@Critical
@DisplayName("Тесты на заключение пари при недостаточном балансе на счету")

public class BettingTest extends TestBase {

    private final AuthSignInComponent authSignInComponent = new AuthSignInComponent();
    private final AuthAccountPhoneConfig authAccountPhoneConfig = ConfigurationManager.getAuthAccountPhoneConfig();
    private final CartFooterComponent cartFooterComponent = new CartFooterComponent();
    private final PopularsHeaderComponent popularsHeaderComponent = new PopularsHeaderComponent();
    private final UserInfoComponent userInfoComponent = new UserInfoComponent();
    private final BettingPage bettingPage = new BettingPage();

    @EnumSource(Betting.class)
    @ParameterizedTest(name = "для {0}")
    @DisplayName("Тест на заключение пари при недостаточном балансе на счету")
    void testBetting(Betting bettingOption) {
        step("Авторизация на сайте", () ->
                authSignInComponent.logInWithPhoneNumber(authAccountPhoneConfig.getAccountPhone(),
                        authAccountPhoneConfig.getPassword()));

        step("Открываем раздел Популярное", popularsHeaderComponent::openTopMatchesSection);

        step(String.format("Выбираем систему ставок %s", bettingOption), () ->
                bettingPage.selectBettingOption(bettingOption.name()));

        step("Вводим сумму ставки и нажимает заключать пари", () ->
                cartFooterComponent
                        .setBetAmount("1000")
                        .clickPlaceBetButton());

        step("Проверка сообщения о результате заключения пари", () ->
                cartFooterComponent.getMessage("Пари не оформлено. Недостаточно средств на счете"));

        step("Выход из аккаунта", userInfoComponent::logOut);
    }
}

