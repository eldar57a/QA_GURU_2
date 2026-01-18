package newTest;

import myTestsPackage.data.Gender;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.PracticeFormRegistrationPage;
import pages.components.ResultsTableComponent;

import java.util.stream.Stream;

public class PageFormAnnotationTest extends TestBase {

    PracticeFormRegistrationPage practiceFormRegistrationPage = new PracticeFormRegistrationPage();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    @BeforeEach
    void precondition() {
        practiceFormRegistrationPage.openPage()
                .removeBanner();
    }

    @Tags({
            @Tag("Smoke"),
            @Tag("Regress"),
            @Tag("FormTest")
    })
    @Order(1)
    @CsvFileSource(resources = "/test_data/subjectsAndHobbies.csv")
    @ParameterizedTest(name = "Проверка регистрации с выбором определенного subjects {0} и hobbies {1}")
    void fullRegistrationFormFieldsShouldBeFilled(String subject, String hobbies) {
        practiceFormRegistrationPage.setFirstName("Eldar")
                .setLastName("Akhnaza")
                .setUserEmail("ea@it-one.ru")
                .setGenterWrapper("Male")
                .setUserNumber("89990009999")
                .setDateOfBirthInput("1", "April", "1995")
                .setSubject(subject)
                .setHobbiesWrapper(hobbies)
                .setUploadPicture("images.jpeg")
                .setCurrencyAddress("Orel")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .setSubmit();
        //Проверка формы
        resultsTableComponent.checkResult("Student Name", "Eldar")
                .checkResult("Student Email", "ea@it-one.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8999000999")
                .checkResult("Date of Birth", "01 April,1995")
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "images.jpeg")
                .checkResult("Address", "Orel")
                .checkResult("State and City", "Uttar Pradesh Agra")
                // Закрытие таблицы
                .closeLargeModal();
    }

    static Stream<Arguments> minimumRegistrationFormFieldsProvider() {
        return Stream.of(
                Arguments.of("Eldar", "Akhnazarov", "ea@it-one.ru", Gender.Male, "8999000999"),
                Arguments.of("Svetlana", "Akhnazarova", "sa@it-one.ru", Gender.Female, "8999000998"),
                Arguments.of("Other", "Akhnazarovo", "oa@it-one.ru", Gender.Other, "8999000995")
        );
    }

    @Tags({
            @Tag("Smoke"),
            @Tag("Regress"),
            @Tag("FormTest")
    })
    @MethodSource("minimumRegistrationFormFieldsProvider")
    @ParameterizedTest(name = "Проверка соответствия минимальных вводных, имени {0} фамилии {1} почты {2} гендера {3} телефона {4}")
    void minimumRegistrationFormFieldsShouldBeFilled(String firstname, String lastname, String email, Gender gender, String phone) {
        practiceFormRegistrationPage
                .setFirstName(firstname)
                .setLastName(lastname)
                .setUserEmail(email)
                .setGenterWrapper(gender.name())
                .setUserNumber(phone)
                .setSubmit();

        // Проверка формы
        resultsTableComponent.checkResult("Student Name", firstname + " " + lastname) // Предполагаем, что в таблице полное имя
                .checkResult("Student Email", email)
                .checkResult("Gender", gender.name())
                .checkResult("Mobile", phone)
                // Закрытие таблицы
                .closeLargeModal();
    }

    @Tags({
            @Tag("Regress"),
            @Tag("FormTest")
    })
    @EnumSource(Gender.class)
    @ParameterizedTest(name = "Проверка ввода гендера {0}")
    void genderFieldRegistrationFormTest(Gender gender) {
        practiceFormRegistrationPage
                .setFirstName("Eldar")
                .setLastName("Akhnaza")
                .setUserEmail("ea@it-one.ru")
                .setGenterWrapper(gender.name())
                .setUserNumber("89990009999")
                .setSubmit();
        //Проверка формы
        resultsTableComponent.checkResult("Student Name", "Eldar")
                .checkResult("Student Email", "ea@it-one.ru")
                .checkResult("Gender", gender.name())
                .checkResult("Mobile", "8999000999")
                // Закрытие таблицы
                .closeLargeModal();

        System.out.println("Выбран гендер " + gender);

    }

}


