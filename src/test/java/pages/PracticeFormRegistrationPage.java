package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormRegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            submit = $("#submit"),
            state = $("#state"),
            city = $("#city");


    CalendarComponent calendarComponent = new CalendarComponent();

    public PracticeFormRegistrationPage openPage() {
        //Открытие браузера
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormRegistrationPage removeBanner() {
        //Удаленние баннеров рекламы
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }
    public PracticeFormRegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public PracticeFormRegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public PracticeFormRegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }
    public PracticeFormRegistrationPage setGenterWrapper(String value){
        genterWrapper.$(byText(value)).click();
        return this;
    }
    public PracticeFormRegistrationPage setUserNumber(String value){
        userNumber.setValue(value);
        return this;
    }
    public PracticeFormRegistrationPage setDateOfBirthInput(String day, String mouth, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, mouth, year);
        return this;
    }
    public PracticeFormRegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public PracticeFormRegistrationPage setHobbiesWrapper(String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public PracticeFormRegistrationPage setUploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public PracticeFormRegistrationPage setCurrencyAddress(String value){
        currentAddress.setValue(value);
        return this;
    }
    public PracticeFormRegistrationPage setState(String value){
        state.click();
        $(byText(value)).click();
        return this;
    }
    public PracticeFormRegistrationPage setCity(String value){
        city.click();
        $(byText(value)).click();
        return this;
    }
    public PracticeFormRegistrationPage setSubmit(){
        submit.click();
        return this;
    }

}
