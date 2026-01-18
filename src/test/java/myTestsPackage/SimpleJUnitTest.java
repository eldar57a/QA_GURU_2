package myTestsPackage;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("\n### beforeAll()\n ");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("\n### AfterAll()\n ");
    }


    @BeforeEach
    void beforeEach() {
        System.out.println("### beforeEach() ");
        result = getResult();
    }

    @AfterEach
    void AfterEach() {
        System.out.println("### AfterEach()\n ");
        result = 0;
    }

    private int getResult() {
        return 3;
    }

    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }

    @Test
    void firstTest() {
        System.out.println("### firstTest() ");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("### secondTest()  ");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("### thirdTest ");
        Assertions.assertTrue(result > 2);
    }
}
