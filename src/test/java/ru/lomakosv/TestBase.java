package ru.lomakosv;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeEach
    void beforeEach() {
        Configuration.browserSize = "1920x1080";
        open("https://betcity.ru/");
    }


}
