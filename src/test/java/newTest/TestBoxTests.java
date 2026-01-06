package newTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TestBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests extends TestBase{

    TestBoxPage testBoxPage = new TestBoxPage();


    @Test
    void fillFormTest() {
        testBoxPage.openPage()
                .setFirstName("Eldar Ah")
                .setUserEmail("eak@it-one.ru")
                .setCurrencyAddress("Some street 1")
                .setPermananetAddress("Another street 2")
                .setSubmit()
                .checkOutput("Name:", "Eldar Ah")
                .checkOutput("Email:", "eak@it-one.ru")
                .checkOutput("Current Address :", "Some street 1")
                .checkOutput("Permananet Address :", "Another street 2");

    }
}
