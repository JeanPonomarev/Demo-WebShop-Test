package com.tricentis.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "RememberMe")
    private WebElement rememberMeCheckbox;

    @FindBy(css = ".login-button")
    private WebElement loginButton;

    @FindBy(css = ".validation-summary-errors>span")
    private WebElement unsuccessfulLoginErrorLabel;

    @FindBy(css = ".validation-summary-errors>ul>li")
    private WebElement noAccountFoundErrorLabel;

    @FindBy(css = "span[for='Email']")
    private WebElement incorrectEmailErrorLabel;

    public void writeEmail(String email) {
        emailField.sendKeys(email);
    }

    public void writePassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickRememberMeCheckbox() {
        rememberMeCheckbox.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void loginUser(String email, String password, boolean rememberMe) {
        writeEmail(email);
        writePassword(password);

        if (rememberMe) {
            clickRememberMeCheckbox();
        }

        clickLoginButton();
    }

    public String getUnsuccessfulLoginErrorLabel() {
        return unsuccessfulLoginErrorLabel.getText();
    }

    public String getNoAccountFoundErrorLabel() {
        return noAccountFoundErrorLabel.getText();
    }

    public String getIncorrectEmailErrorLabel() {
        return incorrectEmailErrorLabel.getText();
    }
}
