package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentsHelper.*;
import static helpers.ConfigHelper.*;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = getBrowserSize();
        Configuration.browser = getBrowser();
        Configuration.baseUrl = getBaseUrl();
        Configuration.assertionMode = SOFT;

        if (getPlatform().equals("selenoid")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = getWebRemoteDriver();
        }

        setEnvironmentAllure("task", System.getProperty("TASK", "test"));
        setEnvironmentAllure("browser", getBrowser());
        setEnvironmentAllure("platform", getPlatform());
    }

    @AfterEach
    void addAttachments() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        closeWebDriver();
        if (getPlatform().equals("selenoid")) {
            attachVideo(getSelenoidVideo());
        }
    }


}
