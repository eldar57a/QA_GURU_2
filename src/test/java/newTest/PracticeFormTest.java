package newTest;

import org.junit.jupiter.api.Test;
import pages.PracticeFormRegistrationPage;
import pages.components.ResultsTableComponent;

public class PracticeFormTest extends TestBase {

    PracticeFormRegistrationPage practiceFormRegistrationPage = new PracticeFormRegistrationPage();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();


    @Test
    void fillPracticeFormTest() {
        practiceFormRegistrationPage.openPage()
                .setFirstName("Eldar")
                .setLastName("Akhnaza")
                .setUserEmail("ea@it-one.ru")
                .setGenterWrapper("Male")
                .setUserNumber("89990009999")
                .setDateOfBirthInput("1", "April", "1995")
                .setSubject("Physics")
                .setHobbiesWrapper("Sports")
                .setUploadPicture("images.jpeg")
                .setCurrencyAddress("Orel1")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .setSubmit();
        //Проверка формы
        resultsTableComponent.checkResult("Student Name", "Eldar")
                .checkResult("Student Email", "ea@it-one.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8999000999")
                .checkResult("Date of Birth", "01 April,1995")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "images.jpeg")
                .checkResult("Address", "Orel")
                .checkResult("State and City", "Uttar Pradesh Agra")
                // Закрытие таблицы
                .closeLargeModal();
    }

    @Test
    void minPracticeFormTest(){
        practiceFormRegistrationPage.openPage()
                .setFirstName("Eldar")
                .setLastName("Akhnaza")
                .setUserEmail("ea@it-one.ru")
                .setGenterWrapper("Male")
                .setUserNumber("89990009999")
                .setSubmit();
        //Проверка формы
        resultsTableComponent.checkResult("Student Name", "Eldar")
                .checkResult("Student Email", "ea@it-one.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8999000999")
                // Закрытие таблицы
                .closeLargeModal();
    }

    @Test
    void negativePracticeFormTest(){
        practiceFormRegistrationPage.openPage()
                .setFirstName("Eldar")
                .setUserEmail("ea@it-one.ru")
                .setGenterWrapper("Male")
                .setUserNumber("89990009999")
                .setSubmit();
        //Проверка отсутствия формы
        resultsTableComponent.checkResultModalNotVisible();
    }

}
