package ru.lomakosv.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import ru.lomakosv.TestBase;
import ru.lomakosv.config.AuthAccountNumberConfig;
import ru.lomakosv.config.AuthAccountPhoneConfig;
import ru.lomakosv.config.ConfigurationManager;
import ru.lomakosv.page.components.AuthSignInComponent;
import ru.lomakosv.page.components.UserInfoComponent;
import ru.lomakosv.helpers.annotanion.Blocker;

import static io.qameta.allure.Allure.step;

@Owner("SLomako")
@Blocker
@DisplayName("Тесты авторизации через главное меню сайта")
public class AuthTest extends TestBase {

    private final AuthSignInComponent authSignInComponent = new AuthSignInComponent();
    private final UserInfoComponent userInfoComponent = new UserInfoComponent();
    private final AuthAccountNumberConfig authAccountNumberConfig = ConfigurationManager.getAuthAccountNumberConfig();
    private final AuthAccountPhoneConfig authAccountPhoneConfig = ConfigurationManager.getAuthAccountPhoneConfig();

    @Test
    @DisplayName("Тест на авторизацию по номеру телефона")
    void testAccountPhoneEntry() {
        step("Вводим номер телефона и пароль", () ->
                authSignInComponent.logInWithPhoneNumber(authAccountPhoneConfig.phone(),
                        authAccountPhoneConfig.password()));

        step("Проверяем успешную авторизацию в системе", () ->
                userInfoComponent.getNumberLogin(authAccountNumberConfig.number()));

        userInfoComponent.logOut();
    }

    @Test
    @DisplayName("Тест на авторизация по номеру счета")
    void testAccountNumberEntry() {
        step("Вводим номер счета и пароль", () ->
                authSignInComponent.logInByAccountNumber(authAccountNumberConfig.number(),
                        authAccountNumberConfig.password()));

        step("Проверяем успешную авторизацию в системе", () ->
                userInfoComponent.getNumberLogin(authAccountNumberConfig.number()));

        userInfoComponent.logOut();
    }
}
