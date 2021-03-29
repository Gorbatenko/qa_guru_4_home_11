package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;

public class LoginTest extends BaseTest{

    private static final String BASE_PATH = "/my";

    @BeforeEach
    void openBaseUrl() {
        open(BASE_PATH);
    }

    @AfterEach
    void afterEach() {
//        https://qa.guru/user/my/logout
    }



    @Test
    @Owner("GorbatenkoVA")
    @Severity(CRITICAL)
    @Story("Проверка авторизационной формы")
    @DisplayName("Логин с неправильной почтой не пропустит в личный кабинет.")
    void test6() {

    }

    @Test
    @Owner("GorbatenkoVA")
    @Severity(CRITICAL)
    @Story("Проверка авторизационной формы")
    @DisplayName("Логин с неправильным паролем не пропустит в личный кабинет.")
    void test7() {

    }

    @Test
    @Owner("GorbatenkoVA")
    @Severity(CRITICAL)
    @Story("Проверка авторизационной формы")
    @DisplayName("Логин с валидными данными ведёт в личный кабинет.")
    void test8() {

    }

    @Test
    @Owner("GorbatenkoVA")
    @Severity(MINOR)
    @Story("Проверка редиректа главной страницы")
    @DisplayName("Авторизованного студента переводит в личный кабинет с главной страницы.")
    void test9() {

    }

    @Test
    @Owner("GorbatenkoVA")
    @Severity(MINOR)
    @Story("Проверка редиректа главной страницы")
    @DisplayName("После выхода из личного кабинета главная страница доступна.")
    void test10() {

    }
}
