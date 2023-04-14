package ru.lomakosv.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.components.AuthSignInComponent;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@DisplayName("Тест авторизации")
@Tag("remote")
public class AuthTest extends TestBase {

    AuthSignInComponent authSignInComponent = new AuthSignInComponent();

    @DisplayName("вход по номеру счет")
    @Test
    void testPhoneEntry() {
        step("Вводим номер номер счета и пароль", () -> {
            authSignInComponent.phoneEntry();
        });
        step("Проверяем что авторизация успешна", () -> {
            $("[class='user-info__item-step-value']").shouldHave(Condition.text("15821548"));
        });

    }

    @DisplayName("вход по номеру телефона")
    @Test
    void acctNumberEntry() {

        step("Вводим номер номер телефона и пароль", () -> {
            authSignInComponent.phoneEntry();
        });
        step("Проверяем что авторизация успешна", () -> {
            $("[class='user-info__item-step-value']").shouldHave(Condition.text("15821548"));
        });


    }


}
