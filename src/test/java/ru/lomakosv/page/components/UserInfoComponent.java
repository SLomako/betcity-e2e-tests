package ru.lomakosv.page.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.aeonbits.owner.ConfigFactory;
import ru.lomakosv.config.VerifyLogon;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class UserInfoComponent {


    private final SelenideElement
            VERIFICATION_NAME_LOGIN = $("[class='user-info__item-step-value']"),
            LOG_OUT_BUTTON = $("[class*=icon_logout-light]");

    public void verifyLogin()  throws IOException  {
            String content = "fff=secret";
            Path propsPath = Paths.get("src/test/resources/verify.properties");
            Files.write(propsPath, content.getBytes(StandardCharsets.UTF_8));

        VerifyLogon virfyLogon = ConfigFactory.create(VerifyLogon.class, System.getProperties());
        step("Проверка номера счета", () -> {
            VERIFICATION_NAME_LOGIN.shouldHave(Condition.text(virfyLogon.verify()));
        });
            Files.delete(propsPath);
    }

    public void logOut() {
        step("Выходим из аккаунта", () -> {
            LOG_OUT_BUTTON.shouldBe(enabled).click();
        });
    }

}
