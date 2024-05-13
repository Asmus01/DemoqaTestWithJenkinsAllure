package com.home;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static randomData.randomDataForStateCity.generatorOfCity;

public class TestBase {
    Faker faker = new Faker();


    public String firstname = faker.name().firstName();
    public String lastname = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.demographic().sex();
    public String mobile = faker.phoneNumber().subscriberNumber(10);

    public String day = String.valueOf(faker.number().numberBetween(1, 28));
    public String month = faker.options().option("January", "February", "March", "April");
    public String year = String.valueOf(faker.number().numberBetween(1990, 2014));

    public String subjects = faker.options().option("Maths","Accounting", "Arts");
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String currentAddress = faker.address().streetAddress();
    public String uploadPicture = "images/MistakeText.jpg";
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = generatorOfCity(state);




    @BeforeAll
    static void setUp() {

       Configuration.browser = System.getProperty("browser_type", "chrome");
       Configuration.browserVersion = System.getProperty("browser_version", "106.0");
       Configuration.remote = System.getProperty("browser_url", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
       Configuration.baseUrl = System.getProperty("base_url", "https://demoqa.com");
       //"https://user1:1234@selenoid.autotests.cloud/wd/hub"

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{

            put("enableVNC", true);
            put("enableVideo", true);
        }});
        Configuration.browserCapabilities = capabilities;

    }



    @BeforeEach
    void addListenerAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
