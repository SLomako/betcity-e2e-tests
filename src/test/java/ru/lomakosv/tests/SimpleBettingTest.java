package ru.lomakosv.tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.SimpleBettingPage;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.CartFooterComponent;

@DisplayName("Тест одиночного пари")
@Tag("remote")
public class SimpleBettingTest extends TestBase {

    SimpleBettingPage simpleBettingPage = new SimpleBettingPage();
    CartFooterComponent cartFooterComponent = new CartFooterComponent();
    AuthSignInComponent authSignInComponent = new AuthSignInComponent();

    @DisplayName("1 событие")
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
