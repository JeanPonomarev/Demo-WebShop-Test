package com.tricentis.demowebshop.test_cases;

import com.tricentis.demowebshop.pages.LoginPage;
import com.tricentis.demowebshop.pages.StartPage;
import com.tricentis.demowebshop.steps.LoginTestSteps;
import com.tricentis.demowebshop.enum_labels.LoginLabels;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import com.tricentis.demowebshop.data_generator.RandomDataGenerator;

import java.util.concurrent.TimeUnit;

@Epic(value = "Login")
@Owner(value = "Jean Ponomarev")
public class LoginTest {
    WebDriver driver;

    StartPage startPage;
    LoginPage loginPage;

    RandomDataGenerator dataGenerator = new RandomDataGenerator();

    private static final String BASIC_URL = "http://demowebshop.tricentis.com/";

    private static final String VALID_EMAIL = "jean1995sib@gmail.com";
    private static final String VALID_PASSWORD = "01011995";

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        startPage = PageFactory.initElements(driver, StartPage.class);
        startPage.open();
        startPage.goToLoginPage();

        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Feature(value = "Login by positive scenario")
    @Story(value = "Login with correct data, Remember Me checkbox is chosen")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testPositiveNoRememberMeLogin() {
        loginPage.loginUser(VALID_EMAIL, VALID_PASSWORD, false);

        LoginTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        LoginTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), VALID_EMAIL);
    }

    @Feature(value = "Login by positive scenario")
    @Story(value = "Login with correct data, Remember Me checkbox is not chosen")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testPositiveRememberMeLogin() {
        loginPage.loginUser(VALID_EMAIL, VALID_PASSWORD, true);

        LoginTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        LoginTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), VALID_EMAIL);
    }

    @Feature(value = "Attempt to log in with wrong email")
    @Story(value = "Login with unregistered email")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testNonexistentEmailLogin() {
        loginPage.loginUser(dataGenerator.getValidEmail(), dataGenerator.getValidPassword(), false);

        LoginTestSteps.checkUnsuccessfulLoginErrorLabelStep(loginPage.getUnsuccessfulLoginErrorLabel(), LoginLabels.UNSUCCESSFUL_LOGIN_ERROR_LABEL.toString());
        LoginTestSteps.checkNoAccountFoundErrorLabelStep(loginPage.getNoAccountFoundErrorLabel(), LoginLabels.NO_ACCOUNT_FOUND_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to log in with wrong email")
    @Story(value = "Login with empty email input field")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void testEmptyEmailLogin() {
        loginPage.loginUser("", dataGenerator.getValidPassword(), false);

        LoginTestSteps.checkUnsuccessfulLoginErrorLabelStep(loginPage.getUnsuccessfulLoginErrorLabel(), LoginLabels.UNSUCCESSFUL_LOGIN_ERROR_LABEL.toString());
        LoginTestSteps.checkNoAccountFoundErrorLabelStep(loginPage.getNoAccountFoundErrorLabel(), LoginLabels.NO_ACCOUNT_FOUND_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to log in with wrong email")
    @Story(value = "Login with invalid email")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void testIncorrectEmailLogin() {
        loginPage.loginUser(dataGenerator.getNormalRandomString(), dataGenerator.getValidPassword(), false);

        LoginTestSteps.checkIncorrectEmailErrorLabelStep(loginPage.getIncorrectEmailErrorLabel(), LoginLabels.INVALID_EMAIL_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to log in with wrong email")
    @Story(value = "Login with large (300 characters) unregistered email")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    public void testLargeNonexistentEmailLogin() {
        loginPage.loginUser(dataGenerator.getLargeEmail(), dataGenerator.getValidPassword(), false);

        LoginTestSteps.checkUnsuccessfulLoginErrorLabelStep(loginPage.getUnsuccessfulLoginErrorLabel(), LoginLabels.UNSUCCESSFUL_LOGIN_ERROR_LABEL.toString());
        LoginTestSteps.checkNoAccountFoundErrorLabelStep(loginPage.getNoAccountFoundErrorLabel(), LoginLabels.NO_ACCOUNT_FOUND_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to log in with incorrect password")
    @Story(value = "Login with wrong password for input registered email")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testIncorrectPasswordLogin() {
        loginPage.loginUser(VALID_EMAIL, dataGenerator.getValidPassword(), false);

        LoginTestSteps.checkUnsuccessfulLoginErrorLabelStep(loginPage.getUnsuccessfulLoginErrorLabel(), LoginLabels.UNSUCCESSFUL_LOGIN_ERROR_LABEL.toString());
        LoginTestSteps.checkNoAccountFoundErrorLabelStep(loginPage.getNoAccountFoundErrorLabel(), LoginLabels.INVALID_PASSWORD_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to log in with incorrect password")
    @Story(value = "Login with empty password field")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void testNoPasswordLogin() {
        loginPage.loginUser(VALID_EMAIL, "", false);

        LoginTestSteps.checkUnsuccessfulLoginErrorLabelStep(loginPage.getUnsuccessfulLoginErrorLabel(), LoginLabels.UNSUCCESSFUL_LOGIN_ERROR_LABEL.toString());
        LoginTestSteps.checkNoAccountFoundErrorLabelStep(loginPage.getNoAccountFoundErrorLabel(), LoginLabels.INVALID_PASSWORD_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to log in with incorrect password")
    @Story(value = "Login with large (300 characters) incorrect password")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    public void testLargeIncorrectPasswordLogin() {
        loginPage.loginUser(VALID_EMAIL, dataGenerator.getLargeRandomString(), false);

        LoginTestSteps.checkUnsuccessfulLoginErrorLabelStep(loginPage.getUnsuccessfulLoginErrorLabel(), LoginLabels.UNSUCCESSFUL_LOGIN_ERROR_LABEL.toString());
        LoginTestSteps.checkNoAccountFoundErrorLabelStep(loginPage.getNoAccountFoundErrorLabel(), LoginLabels.INVALID_PASSWORD_ERROR_LABEL.toString());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
