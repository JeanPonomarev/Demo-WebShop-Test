package com.tricentis.demowebshop.steps;

import io.qameta.allure.Step;
import org.testng.Assert;

public class LoginTestSteps {
    @Step("Verification that current URL \"{actualURL}\" matches the expected one \"{expectedURL}\"")
    public static void checkCurrentURLStep(String actualURL, String expectedURL) {
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Step("Verification that email address \"{actualEmailLabel}\" in the site header matches the expected one \"{expectedEmailLabel}\"")
    public static void checkEmailLabelStep(String actualEmailLabel, String expectedEmailLabel) {
        Assert.assertEquals(actualEmailLabel, expectedEmailLabel);
    }

    @Step("Verification that the login error label \"{actualErrorLabel}\" matches the expected \"{expectedErrorLabel}\"")
    public static void checkUnsuccessfulLoginErrorLabelStep(String actualErrorLabel, String expectedErrorLabel) {
        Assert.assertEquals(actualErrorLabel, expectedErrorLabel);
    }

    @Step("Verification that the label about the absence of an account in the database \"{actualErrorLabel}\" matches the expected \"{expectedErrorLabel}\"")
    public static void checkNoAccountFoundErrorLabelStep(String actualErrorLabel, String expectedErrorLabel) {
        Assert.assertEquals(actualErrorLabel, expectedErrorLabel);
    }

    @Step("Verification that the label \"{actualErrorLabel}\" about an incorrectly entered email matches the expected \"{expectedErrorLabel}\"")
    public static void checkIncorrectEmailErrorLabelStep(String actualErrorLabel, String expectedErrorLabel) {
        Assert.assertEquals(actualErrorLabel, expectedErrorLabel);
    }
}
