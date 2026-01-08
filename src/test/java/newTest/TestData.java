package newTest;

import com.github.javafaker.Faker;

import static utils.RandomUtils.*;
import com.github.javafaker.Faker;
import utils.RandomUtils;

public class TestData {

    Faker faker = new Faker();

    public  String firstName = faker.name().firstName();
    public  String lastName = faker.name().lastName();
    public  String userEmail = getRandomEmail("@email" ,".com");
    public  String userAddress = faker.address().fullAddress();
    public  String userNumber = getRandomRusNumberString();
    public  String userGender = getRandomGenders();
    public  String userHobbies = getRandomHobbiest();
    public  String userState = getRandomState();
    public  String userCity = getRandomCity(userState);
    public  String userCalendarDay = getRandomDay();
    public  String userCalendarMounth = getRandomMounth();
    public  String userCalendarYear = getRandomYear();
    public  String userSubjects = getSubjects();
    public  String userRandomPicture = getRandomPicture();
}
