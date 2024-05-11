package com.home;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TestPageDemoqa;

import static io.qameta.allure.SeverityLevel.CRITICAL;


public class TestDemoqaFormRegistration extends TestBase {


    TestPageDemoqa testPageDemoqa = new TestPageDemoqa();


    @Test
    @Tag("remote")

    @Description("Test of Demoqa Registration Page")
    @Severity(CRITICAL)
    @Owner("Aslan")
    @Link(name = "Demoqa Registration Page", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("DEMOQA")
    @Story("Проверка формы регистрации")
    void demoqaRegistrationForm() {

        testPageDemoqa.openPage()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setBirthDay(day, month, year)
                .setSubject(subjects)
                .setHobby(hobby)
                .setUploadPicture(uploadPicture)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setClick();
        System.out.println();

        testPageDemoqa.verifyModalWindow()
                .verifyModalResults("Student Name", firstname + " " + lastname)
                .verifyModalResults("Student Email", email)
                .verifyModalResults("Gender", gender)
                .verifyModalResults("Mobile", mobile)
                .verifyModalResults("Date of Birth", day + " " + month + "," + year)
                .verifyModalResults("Subjects", subjects)
                .verifyModalResults("Hobbies", hobby)
                .verifyModalResults("Picture", "MistakeText.jpg")
                .verifyModalResults("Address", currentAddress)
                .verifyModalResults("State and City", state + " " + city);


    }
}
