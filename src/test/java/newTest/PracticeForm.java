package newTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {


    @BeforeAll
    static void setupSelenideEnv(){
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 4000;
    }

    @Test
    void fillPracticeFormTest() {
        //Открытие браузера
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        //Заполнение формы
        $("#firstName").setValue("Eldar");
        $("#lastName").setValue("Akh");
        $("#userEmail").setValue("ea@it-one.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89990009999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1995")).click();
        $(".react-datepicker__month-select").$(byText("April")).click();
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("images.jpeg");
        $("#currentAddress").setValue("Orel1");
        $("#submit").scrollTo();
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();
        $("#submit").click();
        //Проверка формы
        $(".table-responsive").shouldHave(text("Student Name"), text("Eldar"));
        $(".table-responsive").shouldHave(text("Student Email"), text("ea@it-one.ru"));
        $(".table-responsive").shouldHave(text("Gender"), text("Male"));
        $(".table-responsive").shouldHave(text("Mobile"), text("8999000999"));
        $(".table-responsive").shouldHave(text("Date of Birth"), text("01 April,1995"));
        $(".table-responsive").shouldHave(text("Subjects"), text("Physics"));
        $(".table-responsive").shouldHave(text("Hobbies"), text("Sports"));
        $(".table-responsive").shouldHave(text("Picture"), text("images.jpeg"));
        $(".table-responsive").shouldHave(text("Address"), text("Orel"));
        $(".table-responsive").shouldHave(text("State and City"), text("Uttar Pradesh Agra"));
        // Закрытие таблицы
        $("#closeLargeModal").click();
    }

}
