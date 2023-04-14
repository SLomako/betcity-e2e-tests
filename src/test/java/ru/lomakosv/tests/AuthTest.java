package ru.lomakosv.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.components.AuthSignInComponent;

import static com.codeborne.selenide.Selenide.$;


@Tag("remote")
public class AuthTest extends TestBase {

    AuthSignInComponent authSignInComponent = new AuthSignInComponent();

    @Test
    void testPhoneEntry() {
        authSignInComponent.phoneEntry();
        $("[class='user-info__item-step-value']").shouldHave(Condition.text("15821548"));
    }

    @Test
    void acctNumberEntry() {
        authSignInComponent.phoneEntry();
        $("[class='user-info__item-step-value']").shouldHave(Condition.text("15821548"));
    }



}
