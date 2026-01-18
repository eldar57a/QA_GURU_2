package newTest;

import org.junit.jupiter.api.Test;
import pages.PracticeFormRegistrationPage;
import pages.components.ResultsTableComponent;
import com.github.javafaker.Faker;


public class PracticeFormPageFakerRandomDataTest extends TestBase {

    TestData testData = new TestData();

    PracticeFormRegistrationPage practiceFormRegistrationPage = new PracticeFormRegistrationPage();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();


    @Test
    void fillPracticeFormTest() {

        practiceFormRegistrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGenterWrapper(testData.userGender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirthInput(testData.userCalendarDay, testData.userCalendarMounth, testData.userCalendarYear)
                .setSubject(testData.userSubjects)
                .setHobbiesWrapper(testData.userHobbies)
                .setUploadPicture(testData.userRandomPicture)
                .setCurrencyAddress(testData.userAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .setSubmit();
        //Проверка формы
        resultsTableComponent.checkResult(testData.firstName + " " + testData.lastName, "Student Name")
                .checkResult(testData.userEmail, "Student Email")
                .checkResult(testData.userGender, "Gender")
                .checkResult(testData.userNumber, "Mobile")
                .checkResult(testData.userCalendarDay + " " + testData.userCalendarMounth + "," + testData.userCalendarYear, "Date of Birth")
                .checkResult(testData.userSubjects, "Subjects")
                .checkResult(testData.userHobbies, "Hobbies")
                .checkResult(testData.userRandomPicture, "Picture")
                .checkResult(testData.userAddress, "Address")
                .checkResult(testData.userState + " " + testData.userCity, "State and City")
                // Закрытие таблицы
                .closeLargeModal();

    }


    @Test
    void minPracticeFormTest() {
        practiceFormRegistrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGenterWrapper(testData.userGender)
                .setUserNumber(testData.userNumber)
                .setSubmit();
        //Проверка формы
        resultsTableComponent.checkResult(testData.firstName + " " + testData.lastName, "Student Name")
                .checkResult(testData.userEmail, "Student Email")
                .checkResult(testData.userGender, "Gender")
                .checkResult(testData.userNumber, "Mobile")
                // Закрытие таблицы
                .closeLargeModal();
    }

    @Test
    void negativePracticeFormTest() {
        practiceFormRegistrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setUserEmail(testData.userEmail)
                .setGenterWrapper(testData.userGender)
                .setUserNumber(testData.userNumber)
                .setSubmit();
        //Проверка отсутствия формы
        resultsTableComponent.checkResultModalNotVisible();
    }

}
