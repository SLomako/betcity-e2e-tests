package ru.lomakosv.tests;

import org.junit.jupiter.api.Test;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.CartFooterComponent;
import ru.lomakosv.page.ExpressBettingPage;

public class ExpressBettingTest extends TestBase {

    ExpressBettingPage expressBettingPage = new ExpressBettingPage();
    CartFooterComponent cartFooterComponent = new CartFooterComponent();
    AuthSignInComponent authSignInComponent = new AuthSignInComponent();

    @Test
    void testExpressBetting() {

        authSignInComponent.acctNumberEntry();

        expressBettingPage.openPopularsChamps()
                .chooseBetTwoEvent()
                .chooseExpressBetting()
                .depositTheAmount("1000")
                .confirmBet();

        cartFooterComponent.verifyMessage("Пари не оформлено. Недостаточно средств на счете");

    }

}
