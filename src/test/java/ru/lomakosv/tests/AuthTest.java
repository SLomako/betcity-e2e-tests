package ru.lomakosv.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.lomakosv.TestBase;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.UserInfoComponent;
import ru.lomakosv.utils.Blocker;

import static io.qameta.allure.Allure.step;

@Owner("SLomako")
@Blocker
@DisplayName("Тест авторизации через главное меню сайта")
@Tag("remote")
public class AuthTest extends TestBase {

    AuthSignInComponent authSignInComponent = new AuthSignInComponent();
    UserInfoComponent userInfoComponent = new UserInfoComponent();

    @Tag("1")
    @DisplayName("вход по номеру телефона")
    @Test
    void testAccountPhoneEntry() {

        step("Вводим номер телефона и пароль", () -> {
            authSignInComponent.accountPhoneEntry();
        });
        step("Проверяем что авторизация успешна", () -> {
            userInfoComponent.verifyLogin();
        });

        userInfoComponent.logOut();

    }

    @Tag("2")
    @DisplayName("вход по номеру счет")
    @Test
    void testAccountNumberEntry() {

        step("Вводим номер счета и пароль", () -> {
            authSignInComponent.accountNumberEntry();
        });
        step("Проверяем что авторизация успешна", () -> {
            userInfoComponent.verifyLogin();
        });

        userInfoComponent.logOut();

    }
}
