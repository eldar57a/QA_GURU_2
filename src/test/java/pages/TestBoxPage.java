package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TextBoxOutput;

import static com.codeborne.selenide.Selenide.*;

public class TestBoxPage {
    private final SelenideElement
            fullNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddress = $("#currentAddress" ),
            permanentAddress = $("#permanentAddress"),
            submit = $("#submit");

    public TestBoxPage openPage() {
        //Открытие браузера и формы
        open("/text-box");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }
    public TestBoxPage setFirstName(String value){
        fullNameInput.setValue(value);
        return this;
    }

    public TestBoxPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }
    public TestBoxPage  setCurrencyAddress(String value){
        currentAddress.setValue(value);
        return this;
    }
    public TestBoxPage setPermananetAddress(String value){
        permanentAddress.setValue(value);
        return this;
    }
    public TestBoxPage setSubmit() {
        submit.click();
        return this;
    }

    public TestBoxPage checkOutput(String key, String value) {
        TextBoxOutput.setOutput(key, value);
        return this;
    }
}
