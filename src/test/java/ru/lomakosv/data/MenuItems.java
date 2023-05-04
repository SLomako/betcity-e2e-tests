package ru.lomakosv.data;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public enum MenuItems {
    RU(Locale.forLanguageTag("ru"), Arrays.asList("ЛИНИЯ", "LIVE", "LIVE-КАЛЕНДАРЬ", "LIVE-РЕЗУЛЬТАТЫ", "РЕЗУЛЬТАТЫ", "СТАТИСТИКА", "ИНФОРМАЦИЯ", "ПРОМО")),
    EN(Locale.forLanguageTag("en"), Arrays.asList("BETTING LIST", "LIVE", "LIVE-CALENDAR", "LIVE-RESULTS", "RESULTS", "STATISTICS", "INFORMATION", "PROMO"));

    private final Locale locale;
    private final List<String> menuNames;

    MenuItems(Locale locale, List<String> menuNames) {
        this.locale = locale;
        this.menuNames = menuNames;
    }

    public Locale getLocale() {
        return locale;
    }

    public List<String> getMenuNames() {
        return menuNames;
    }
}

