package ru.lomakosv.tests;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.lomakosv.enums.Locale;
import ru.lomakosv.TestBase;
import ru.lomakosv.utils.Critical;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Owner("SLomako")
@Critical
@DisplayName("Тест наименований меню в разных locale")
public class LocalMenuTest extends TestBase {

    static Stream<Arguments> testMenuDependingOnTheLocal() {
        return Stream.of(
                Arguments.of(Locale.ru, List.of("ЛИНИЯ", "LIVE", "LIVE-КАЛЕНДАРЬ", "LIVE-РЕЗУЛЬТАТЫ", "РЕЗУЛЬТАТЫ", "СТАТИСТИКА", "ИНФОРМАЦИЯ", "ПРОМО")),
                Arguments.of(Locale.en, List.of("BETTING LIST", "LIVE", "LIVE-CALENDAR", "LIVE-RESULTS", "RESULTS", "STATISTICS", "INFORMATION", "PROMO"))
        );
    }

    @DisplayName("")
    @ParameterizedTest(name = "В первом результате выдачи для {0} должен отображаться текст {1}")
    @MethodSource
    @Tags({@Tag("web1"), @Tag("critical")})
    void testMenuDependingOnTheLocal(Locale locale, List<String> expectedButtons) {

        step("Нажимаем на значек смену языка", () -> {
            $("[class='custom-select menu-lang']").click();
        });

        step("Выбираем язык для сайта", () -> {
            $$("[class='custom-select-popup-item__text']").find(text(locale.name())).click();
        });

        step("Проверка изменения наименований меню согласно выбраному языку", () -> {
            $$("[class='menu'] a").filter(visible).shouldHave(CollectionCondition.texts(expectedButtons));
        });

    }
}
