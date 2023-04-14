package ru.lomakosv.tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.lomakosv.Locale;
import ru.lomakosv.TestBase;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
@Disabled
@DisplayName("Тест меню в разных locale")
@Tag("remote")
public class LocalMenuTest extends TestBase {

    static Stream<Arguments> testMenuDependingOnTheLocal() {
        return Stream.of(
                Arguments.of(Locale.ru, List.of("ЛИНИЯ", "LIVE", "LIVE-КАЛЕНДАРЬ", "LIVE-РЕЗУЛЬТАТЫ", "РЕЗУЛЬТАТЫ", "СТАТИСТИКА", "ИНФОРМАЦИЯ", "ПРОМО")),
                Arguments.of(Locale.en, List.of("BETTING LIST", "LIVE", "LIVE-CALENDAR", "LIVE-RESULTS", "RESULTS", "STATISTICS", "INFORMATION", "PROMO"))
        );
    }

    @ParameterizedTest(name = "В первом результате выдачи для {0} должен отображаться текст {1}")
    @MethodSource
    void testMenuDependingOnTheLocal(Locale locale, List<String> expectedButtons) {

        $("[class='custom-select menu-lang']").click();
        $$("[class='custom-select-popup-item__text']").find(text(locale.name())).click();
        $$("[class='menu'] a").filter(visible).shouldHave(CollectionCondition.texts(expectedButtons));
    }
}
