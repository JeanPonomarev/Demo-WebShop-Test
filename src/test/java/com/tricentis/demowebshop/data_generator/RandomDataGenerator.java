package com.tricentis.demowebshop.data_generator;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomDataGenerator {
    Faker faker = new Faker();
    Faker rusFaker = new Faker(new Locale("ru"));

    public String getValidFirstName() {
        return faker.name().firstName();
    }

    public String getValidLastName() {
        return faker.name().lastName();
    }

    public String getValidEmail() {
        return faker.internet().emailAddress();
    }

    public String getValidPassword() {
        return faker.internet().password(6, 12);
    }

    public String getShortPassword() {
        return faker.internet().password(1,5);
    }

    public String getNormalRandomString() {
        return faker.regexify("[a-zA-Z]{10}");
    }

    public String getLargeRandomString() {
        return faker.regexify("[a-zA-Z]{300}");
    }

    public String getRussianFirstName() {
        return rusFaker.name().firstName();
    }

    public String getRussianLastName() {
        return rusFaker.name().lastName();
    }

    public String getNameWithNumbers() {
        return faker.regexify("[1-9]{5}") + getValidFirstName();
    }

    public String getNameWithCharacters() {
        return faker.regexify("[$&+,:;=?@#|'<>.^*()%!-]{5}") + getValidFirstName();
    }

    public String getLargeEmail() {
        return getLargeRandomString() + getValidEmail();
    }
}
