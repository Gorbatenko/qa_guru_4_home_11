package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class QaGuruTest extends BaseTest{

    @BeforeEach
    void openBaseUrl() {
        open();
    }

    @Test
    @Owner("GorbatenkoVA")
    @DisplayName("Наличие всех заявленных инструментов в программе обучения")
    void test1() {

    }

    @Test
    @DisplayName("Наличие всех заявленных преподавателей в программе обучения")
    void test2() {

    }

    @Test
    @DisplayName("Кнопка 'Начать обучение' ведёт к записи на курс.")
    void test3() {

    }

    @Test
    @DisplayName("Кнопка 'Как оплатить' ведёт в телеграмм.")
    void test4() {

    }

    @Test
    @DisplayName("Цена обучения для разных уровней актуальна.")
    void test5() {

    }

}
