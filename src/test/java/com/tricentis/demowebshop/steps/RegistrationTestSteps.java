package com.tricentis.demowebshop.steps;

import io.qameta.allure.Step;
import org.testng.Assert;

public class RegistrationTestSteps {
    @Step("Verification that actual successful registration label \"{actualLabel}\" matches the expected \"{expectedLabel}\"")
    public static void checkSuccessfulRegistrationLabelStep(String actualLabel, String expectedLabel) {
        Assert.assertEquals(actualLabel, expectedLabel);
    }

    @Step("Verification that current URL \"{actualURL}\" matches the expected one \"{expectedURL}\"")
    public static void checkCurrentURLStep(String actualURL, String expectedURL) {
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Step("Verification that email address \"{actualEmailLabel}\" in the site header matches the expected one \"{expectedEmailLabel}\"")
    public static void checkEmailLabelStep(String actualEmailLabel, String expectedEmailLabel) {
        Assert.assertEquals(actualEmailLabel, expectedEmailLabel);
    }

    @Step("Verification that error label \"{actualLabel}\" for incorrect first name field matches expected \"{expectedLabel}\"")
    public static void checkFirstNameErrorLabel(String actualLabel, String expectedLabel) {
        Assert.assertEquals(actualLabel, expectedLabel);
    }

    @Step("Verification that error label \"{actualLabel}\" for incorrect last name field matches expected \"{expectedLabel}\"")
    public static void checkLastNameErrorLabel(String actualLabel, String expectedLabel) {
        Assert.assertEquals(actualLabel, expectedLabel);
    }

    @Step("Verification that error label \"{actualLabel}\" for incorrect email field matches expected \"{expectedLabel}\"")
    public static void checkEmailErrorLabel(String actualLabel, String expectedLabel) {
        Assert.assertEquals(actualLabel, expectedLabel);
    }

    @Step("Verification that error label \"{actualLabel}\" for already registered email matches expected \"{expectedLabel}\"")
    public static void checkEmailAlreadyExistsErrorLabel(String actualLabel, String expectedLabel) {
        Assert.assertEquals(actualLabel, expectedLabel);
    }

    @Step("Verification that error password label \"{actualLabel}\" matches expected \"{expectedLabel}\"")
    public static void checkPasswordErrorLabel(String actualLabel, String expectedLabel) {
        Assert.assertEquals(actualLabel, expectedLabel);
    }

    @Step("Verification that error confirm password label \"{actualLabel}\" matches expected \"{expectedLabel}\"")
    public static void checkConfirmPasswordErrorLabel(String actualLabel, String expectedLabel) {
        Assert.assertEquals(actualLabel, expectedLabel);
    }
}
