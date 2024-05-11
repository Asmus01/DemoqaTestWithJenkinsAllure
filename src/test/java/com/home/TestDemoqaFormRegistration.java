package com.home;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TestPageDemoqa;


public class TestDemoqaFormRegistration extends TestBase {

    TestPageDemoqa testPageDemoqa = new TestPageDemoqa();


    @Test
    @Tag("remote")
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
