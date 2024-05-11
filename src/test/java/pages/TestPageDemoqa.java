package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPageDemoqa {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public TestPageDemoqa openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#RightSide_Advertisement').remove()");//delete ads-banners
        Selenide.executeJavaScript("$('footer').remove()");//delete footer
        Selenide.executeJavaScript("$('#fixedban').remove()");//delete ads-banner
        return this;
    }

    public TestPageDemoqa setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public TestPageDemoqa setLastName(String value) {
        lastNameInput.setValue(value);
        return this;

    }

    public TestPageDemoqa setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public TestPageDemoqa setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public TestPageDemoqa setMobile(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public TestPageDemoqa setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDayOfBirth(day, month, year);
        return this;

    }

    public TestPageDemoqa setSubject(String value) {

        $("#subjectsInput").setValue("a");
        $(byText(value)).click();
        return this;
    }

    public TestPageDemoqa setHobby(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public TestPageDemoqa setUploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public TestPageDemoqa setAddress (String value) {
        $("#currentAddress").setValue(value);
        return this;

    }

    public TestPageDemoqa setState (String value) {
        $("#state").click();
        $(byText(value)).click();
        return this;
    }

    public TestPageDemoqa setCity (String value) {
        $("#city").click();
        $(byText(value)).click();
        return this;

    }

    public TestPageDemoqa setClick() {
        $("#submit").click();
        return this;

    }
    public TestPageDemoqa verifyModalWindow() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public TestPageDemoqa verifyModalResults(String key, String value) {
        registrationResultsModal.verifyResultsModal(key, value);
        return this;
    }
}
