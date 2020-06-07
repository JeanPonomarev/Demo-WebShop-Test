package com.tricentis.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage {
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".ico-register")
    private WebElement registrationReference;

    @FindBy(className = "account")
    private WebElement accountReference;

    @FindBy(css = ".ico-login")
    private WebElement loginReference;

    public void open() {
        driver.get("http://demowebshop.tricentis.com/");
    }

    public void goToRegistrationPage() {
        registrationReference.click();
    }

    public void goToLoginPage() {
        loginReference.click();
    }

    public String getEmailLabel() {
        return accountReference.getText();
    }
}
