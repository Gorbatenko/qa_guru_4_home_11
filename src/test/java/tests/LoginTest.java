package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest{

    private static final String BASE_PATH = "/my";

    @BeforeEach
    void openBaseUrl() {
        open(BASE_PATH);
    }

    @Test
    @DisplayName("Логин с неправильной почтой не пропустит в личный кабинет.")
    void test6() {

    }

    @Test
    @DisplayName("Логин с неправильным паролем не пропустит в личный кабинет.")
    void test7() {

    }

    @Test
    @DisplayName("Логин с валидными данными ведёт в личный кабинет.")
    void test8() {

    }

    @Test
    @DisplayName("Авторизованного студента переводит в личный кабинет с главной страницы.")
    void test9() {

    }

    @Test
    @DisplayName("После выхода из личного кабинета главная страница доступна.")
    void test10() {

    }
}
