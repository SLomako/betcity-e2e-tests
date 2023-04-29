package ru.lomakosv.page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class PopularsHeaderComponent {

    static final SelenideElement SELECT_TOP_MATCH = $("[class*='left-filter__list populars__champs'] :first-child");

    public void openPopularsChamps() {

        step("В меню Популярное выбираем ТОП матчи", () -> {
            SELECT_TOP_MATCH.click();
        });
    }
}
