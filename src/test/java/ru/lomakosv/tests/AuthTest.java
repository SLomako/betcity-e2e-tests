package ru.lomakosv.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.UserInfoComponent;

import static io.qameta.allure.Allure.step;

@DisplayName("Тест авторизации")
@Tag("remote")
public class AuthTest extends TestBase {

    AuthSignInComponent authSignInComponent = new AuthSignInComponent();
    UserInfoComponent userInfoComponent = new UserInfoComponent();

    @DisplayName("вход по номеру счет")
    @Test
    void testPhoneEntry() {
        step("Вводим номер номер счета и пароль", () -> {
            authSignInComponent.accountNumberEntry();
        });
        step("Проверяем что авторизация успешна", () -> {
            userInfoComponent.verifyLogin();
        });

    }


    @DisplayName("вход по номеру телефона")
    @Test
    void acctNumberEntry() {

        step("Вводим номер номер телефона и пароль", () -> {
            authSignInComponent.phoneEntry();
        });
        step("Проверяем что авторизация успешна", () -> {
            userInfoComponent.verifyLogin();
        });


    }


}
