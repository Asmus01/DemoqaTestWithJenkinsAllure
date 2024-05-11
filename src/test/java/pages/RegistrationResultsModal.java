package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    public void verifyModalAppears() {
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
    }
    public void verifyResultsModal(String key, String value) {

        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));


//        $("tbody").shouldHave(text(firstname + " " + lastname), text(email), text(gender),
//                text(mobile), text(subjects), text(hobby), text(currentAddress));
    }
}
