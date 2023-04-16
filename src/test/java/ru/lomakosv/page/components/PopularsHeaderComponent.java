package ru.lomakosv.page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PopularsHeaderComponent {

    static final SelenideElement SELECT_TOP_MATCH = $("[class*='left-filter__list populars__champs'] :first-child");

    public void openPopularsChamps() {
        SELECT_TOP_MATCH.click();
    }
}
