package com.tricentis.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "gender-male")
    private WebElement genderMaleRadio;

    @FindBy(id = "gender-female")
    private WebElement genderFemaleRadio;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(className = "result")
    private WebElement registrationCompletedLabel;

    @FindBy(css = ".register-continue-button")
    private WebElement continueButton;

    @FindBy(css = ".field-validation-error [for='FirstName']")
    private WebElement firstNameErrorLabel;

    @FindBy(css = ".field-validation-error [for='LastName']")
    private WebElement lastNameErrorLabel;

    @FindBy(css = ".field-validation-error [for='Email']")
    private WebElement emailErrorLabel;

    @FindBy(css = ".field-validation-error [for='Password']")
    private WebElement passwordErrorLabel;

    @FindBy(css = ".field-validation-error [for='ConfirmPassword']")
    private WebElement confirmPasswordErrorLabel;

    @FindBy(css = ".validation-summary-errors li")
    private WebElement emailAlreadyExistsErrorLabel;

    public void selectMaleGenderRadio() {
        genderMaleRadio.click();
    }

    public void selectFemaleGenderRadio() {
        genderFemaleRadio.click();
    }

    public void writeFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void writeLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void writeEmail(String email) {
        emailField.sendKeys(email);
    }

    public void writePassword(String password) {
        passwordField.sendKeys(password);
    }

    public void writeConfirmPassword(String password) {
        confirmPasswordField.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void registerNewUser(boolean gender, String firstName, String lastName, String email, String password, String confirmPassword) {
        if (gender) {
            selectMaleGenderRadio();
        } else {
            selectFemaleGenderRadio();
        }

        writeFirstName(firstName);
        writeLastName(lastName);
        writeEmail(email);
        writePassword(password);
        writeConfirmPassword(confirmPassword);

        registerButton.click();
    }

    public void registerNewUser(String firstName, String lastName, String email, String password, String confirmPassword) {
        writeFirstName(firstName);
        writeLastName(lastName);
        writeEmail(email);
        writePassword(password);
        writeConfirmPassword(confirmPassword);

        registerButton.click();
    }

    public String getSuccessfulRegistrationLabel() {
        return registrationCompletedLabel.getText();
    }

    public String getFirstNameErrorLabel() {
        return firstNameErrorLabel.getText();
    }

    public String getLastNameErrorLabel() {
        return lastNameErrorLabel.getText();
    }

    public String getEmailErrorLabel() {
        return emailErrorLabel.getText();
    }

    public String getPasswordErrorLabel() {
        return passwordErrorLabel.getText();
    }

    public String getConfirmPasswordErrorLabel() {
        return confirmPasswordErrorLabel.getText();
    }

    public String getEmailAlreadyExistsErrorLabel() {
        return emailAlreadyExistsErrorLabel.getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
