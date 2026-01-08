package utils;

import com.github.javafaker.Faker;


import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.security.SecureRandom;

public class RandomUtils {
    static Faker faker = new Faker();


    public static void main(String[] arg) {
        System.out.println(getRandomString(5));
        System.out.println(getRandomEmail("@email", ".ru"));
        System.out.println(getRandomInt(1, 333));
        System.out.println(getRandomRusNumberString());
        System.out.println(getRandomGenders());
        System.out.println(getRandomState());
        System.out.println(getRandomCity(getRandomState()));
        System.out.println(getRandomDay());
        System.out.println(getRandomMounth());
        System.out.println(getRandomYear());
        System.out.println(getRandomDay() + " " + getRandomMounth() + " " + getRandomYear());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.number().numberBetween(10, 28));

    }

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZakedefghiiklmnorarstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder result = new StringBuilder();
        for
        (int i = 0; i < len; i++)
            result.append(AB.charAt(rnd.nextInt(AB.length())));

        return result.toString();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomRusNumberString() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getRandomEmail(String domain, String local) {
        return getRandomString(6) + domain + local;

    }


    public static String getRandomGenders() {
        return faker.options().option("Male", "Female", "Other");
    }


    public static String getRandomHobbiest() {
        return faker.options().option("Sports", "Reading", "Music");
    }


    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }


    public static String getRandomDay() {
        return faker.number().numberBetween(1, 28) + "";
    }


    public static String getRandomMounth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }


    public static String getRandomYear() {
        return faker.number().numberBetween(1950, 2015) + "";
    }


    public static String getSubjects() {
        return faker.options().option("Maths", "Accounting", "Arts", "Social Studies");
    }


    public static String getRandomPicture() {
        return faker.options().option("company.jpeg", "country.jpeg");
    }


    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };

    }

}
