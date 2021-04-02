package tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import config.EnvironmentConfig;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

@ExtendWith({SoftAssertsExtension.class})
public class QaGuruTest extends BaseTest {
    private final EnvironmentConfig envConfig = ConfigFactory.create(EnvironmentConfig.class);

    @BeforeEach
    void openBaseUrl() {
        step("Переход на страницу " + envConfig.getBaseUrl(), () -> {
            open("/");
        });

    }

    @Test
    @Severity(NORMAL)
    @Owner("GorbatenkoVA")
    @Story("Проверка общей информации")
    @DisplayName("Наличие всех заявленных инструментов в программе обучения")
    void testCheckAllInstrumentsInEducationProgram() {
        List<String> skills = new ArrayList<>();
        step("Составление списка заявленных инструментов", () -> {
            ElementsCollection skillsList = $$(".skills-box p").shouldHaveSize(18);
            for (SelenideElement skill : skillsList) {
                skills.add(skill.text());
            }
        });

        step("Просмотр программы обучения", () -> {
            $("#myBtn").click();
        });

        step("Поиск заявленных инструментов в программе обучения", () -> {
            for (String skill : skills) {
                $(".lesson-list").shouldHave(text(skill));
            }
        });
    }

    @Test
    @Severity(NORMAL)
    @Owner("GorbatenkoVA")
    @Story("Проверка общей информации")
    @DisplayName("Наличие всех заявленных преподавателей в программе обучения")
    void testCheckAllLectorsInEducationProgram() {
        List<String> trainers = new ArrayList<>();
        trainers.add("Ерошенко");
        trainers.add("Виноградов");
        trainers.add("Орлов");
        trainers.add("Васенков");
        trainers.add("Данилов");

        step("Просмотр программы обучения", () -> {
            $("#myBtn").click();
        });

        step("Поиск заявленных преподавателей в программе обучения", () -> {
            for (String trainer : trainers) {
                $(".lesson-list").shouldHave(text(trainer));
            }
        });
    }

    @Test
    @Severity(CRITICAL)
    @Owner("GorbatenkoVA")
    @Story("Проверка контактов")
    @DisplayName("Кнопка 'Начать обучение' ведёт к записи на курс.")
    void test3() {
        $x("//button[contains(text(),'Записаться')]").shouldNot(appear);
        $x("//header//a[contains(text(),'Начать обучение')]").click();
        $x("//button[contains(text(),'Записаться')]").should(visible);
    }

    @Test
    @Severity(NORMAL)
    @Owner("GorbatenkoVA")
    @Story("Проверка контактов")
    @DisplayName("Ссылка в разделе 'Как оплатить' ведёт в телеграмм.")
    void test4() {
        $(byText("Как оплатить?")).click();
        $(byText("https://t.me/cnokoino"))
                .shouldHave(attribute("href","https://t.me/cnokoino"));
    }

    @Test
    @Severity(CRITICAL)
    @Owner("GorbatenkoVA")
    @Story("Проверка общей информации")
    @DisplayName("Цена обучения для разных уровней актуальна.")
    void testCheckPrice() {
        $$("#offers h3")
                .shouldHave(texts(
                        "Первый вариант 15 000 ₽",
                        "Второй вариант 22 500 ₽",
                        "Третий вариант 28 000 ₽"));
    }

}
