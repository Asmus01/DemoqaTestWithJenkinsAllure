package pages;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDayOfBirth(String day, String month, String year) {

        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $("div.react-datepicker__day--0" + day).click();
    }

}
