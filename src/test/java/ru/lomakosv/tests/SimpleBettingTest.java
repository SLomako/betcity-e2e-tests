package ru.lomakosv.tests;


import org.junit.jupiter.api.Test;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.SimpleBettingPage;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.CartFooterComponent;

public class SimpleBettingTest extends TestBase {

    SimpleBettingPage simpleBettingPage = new SimpleBettingPage();
    CartFooterComponent cartFooterComponent = new CartFooterComponent();
    AuthSignInComponent authSignInComponent = new AuthSignInComponent();

    @Test
    void testSimpleBetting() {

        authSignInComponent.acctNumberEntry();
        simpleBettingPage.openPopularsChamps()
                .chooseBetOneEvent()
                .chooseSimpleBetting()
                .depositTheAmount("1000")
                .confirmBet();
        cartFooterComponent.verifyMessage("Пари не оформлено. Недостаточно средств на счете");

    }
}
