package newTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    @BeforeAll
    static void setupSelenideEnv(){
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl ="https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
//        Configuration.timeout = 5000;
    }
}
