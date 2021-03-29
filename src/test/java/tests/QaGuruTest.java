package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

public class QaGuruTest extends BaseTest{

    @BeforeEach
    void openBaseUrl() {
        open();
    }

    @Test
    @Severity(NORMAL)
    @Owner("GorbatenkoVA")
    @Story("Проверка общей информации")
    @DisplayName("Наличие всех заявленных инструментов в программе обучения")
    void test1() {

    }

    @Test
    @Severity(NORMAL)
    @Owner("GorbatenkoVA")
    @Story("Проверка общей информации")
    @DisplayName("Наличие всех заявленных преподавателей в программе обучения")
    void test2() {

    }

    @Test
    @Severity(CRITICAL)
    @Owner("GorbatenkoVA")
    @Story("Проверка контактов")
    @DisplayName("Кнопка 'Начать обучение' ведёт к записи на курс.")
    void test3() {

    }

    @Test
    @Severity(NORMAL)
    @Owner("GorbatenkoVA")
    @Story("Проверка контактов")
    @DisplayName("Кнопка 'Как оплатить' ведёт в телеграмм.")
    void test4() {

    }

    @Test
    @Severity(CRITICAL)
    @Owner("GorbatenkoVA")
    @Story("Проверка общей информации")
    @DisplayName("Цена обучения для разных уровней актуальна.")
    void test5() {

    }

}
