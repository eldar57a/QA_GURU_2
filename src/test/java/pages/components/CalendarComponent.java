package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String mouth, String year) {
        $(".react-datepicker__year-select").$(byText("1995")).click();
        $(".react-datepicker__month-select").$(byText("April")).click();
        $(".react-datepicker__day--001").click();
    }
}
