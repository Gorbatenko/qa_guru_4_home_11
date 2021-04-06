package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.EnvironmentConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileOutputStream;
import java.io.IOException;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.AttachmentsHelper.*;

public class BaseTest {
    private static EnvironmentConfig envConfig = ConfigFactory.create(EnvironmentConfig.class);

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browserSize = envConfig.getBrowserSize();
        Configuration.browser = envConfig.getBrowser();
        Configuration.baseUrl = envConfig.getBaseUrl();
        Configuration.assertionMode = SOFT;

        if (envConfig.getPlatform().equals("selenoid")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = String.format(
                    envConfig.getSelenoidRemote(),
                    envConfig.getSelenoidLogin(),
                    envConfig.getSelenoidPassword());
        }

        setEnvironmentAllure("task", System.getProperty("TASK", "test"));
        setEnvironmentAllure("browser", envConfig.getBrowser());
        setEnvironmentAllure("platform", envConfig.getPlatform());
    }

    @AfterEach
    void afterEach() {
        attachPageSource();
        attachScreenshot("Last screenshot");
        if (envConfig.getPlatform().equals("selenoid")) {
            attachVideo();
            closeWebDriver();
        }
    }

    private static void setEnvironmentAllure(String key, String value) {
        String text = key + "=" + value + "\n";

        try (FileOutputStream fos = new FileOutputStream("build/allure-results/environment.properties", true)) {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ignored) {
        }
    }
}
