package ru.lomakosv.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.SystemBettingPage;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.CartFooterComponent;

@DisplayName("Тест системы пари")
@Tag("remote")
public class SystemBettingTest extends TestBase {

    SystemBettingPage systemBettingPage = new SystemBettingPage();
    CartFooterComponent cartFooterComponent = new CartFooterComponent();
    AuthSignInComponent authSignInComponent = new AuthSignInComponent();


    @DisplayName("3 события")
    @Test
    void testSystemBetting() {
        authSignInComponent.phoneEntry();

        systemBettingPage.openPopularsChamps()
                .chooseBetThreeEvent()
                .chooseSystemBetting()
                .depositTheAmount("1000")
                .confirmBet();

        cartFooterComponent.verifyMessage("Пари не оформлено. Недостаточно средств на счете");
    }
}
