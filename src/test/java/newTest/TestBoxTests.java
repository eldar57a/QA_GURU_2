package newTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("input#userName").setValue("Eldar");
        $("#userEmail").setValue("eakhnazarov@it-one.ru");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 2");
        $("#submit").click();
        $("#output #name").shouldHave(text("Eldar"));
        $("#output #email").shouldHave(text("eakhnazarov@it-one.ru"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 2"));
    }
}
