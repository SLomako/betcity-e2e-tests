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
import ru.lomakosv.utils.Blocker;

import static io.qameta.allure.Allure.step;

@Owner("SLomako")
@Blocker
@DisplayName("Тест авторизации через главное меню сайта")
public class AuthTest extends TestBase {

    private final AuthSignInComponent authSignInComponent = new AuthSignInComponent();
    private final UserInfoComponent userInfoComponent = new UserInfoComponent();
    private final AuthAccountNumberConfig authAccountNumberConfig = ConfigurationManager.getAuthAccountNumberConfig();
    private final AuthAccountPhoneConfig authAccountPhoneConfig = ConfigurationManager.getAuthAccountPhoneConfig();


    @DisplayName("Авторизация по номеру телефона")
    @Test
    void testAccountPhoneEntry() {
        step("Вводим номер телефона и пароль", () -> {
            authSignInComponent.logInWithPhoneNumber(authAccountPhoneConfig.accountPhone(), authAccountPhoneConfig.password());
        });
        step("Проверяем что авторизация прошла успешна", userInfoComponent::checkLogin);
        userInfoComponent.logOut();
    }

    @DisplayName("Авторизация по номеру счета")
    @Test
    void testAccountNumberEntry() {
        step("Вводим номер счета и пароль", () -> {
            authSignInComponent.logInByAccountNumber(authAccountNumberConfig.accountNumber(), authAccountNumberConfig.password());
        });
        step("Проверяем что авторизация прошла успешна", userInfoComponent::checkLogin);
        userInfoComponent.logOut();
    }
}
