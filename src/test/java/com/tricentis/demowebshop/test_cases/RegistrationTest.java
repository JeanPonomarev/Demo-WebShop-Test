package com.tricentis.demowebshop.test_cases;

import com.tricentis.demowebshop.pages.RegistrationPage;
import com.tricentis.demowebshop.pages.StartPage;
import com.tricentis.demowebshop.steps.RegistrationTestSteps;
import com.tricentis.demowebshop.enum_labels.RegistrationLabels;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import com.tricentis.demowebshop.data_generator.RandomDataGenerator;

import java.util.concurrent.TimeUnit;

@Epic(value = "Register")
@Owner(value = "Jean Ponomarev")
public class RegistrationTest {
    WebDriver driver;

    StartPage startPage;
    RegistrationPage registrationPage;

    RandomDataGenerator dataGenerator = new RandomDataGenerator();

    private static final String BASIC_URL = "http://demowebshop.tricentis.com/";
    private static final String REGISTERED_EMAIL = "jean1995sib@gmail.com";
    private static final String WRONG_EMAIL_DOMEN = "@gmail.ru";

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        startPage = PageFactory.initElements(driver, StartPage.class);
        startPage.open();
        startPage.goToRegistrationPage();

        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
    }

    @Feature(value = "Registration by positive scenario")
    @Description(value = "Registration with correct data, gender male selected")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testPositiveMaleRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Registration by positive scenario")
    @Description(value = "Registration with correct data, gender female selected")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testPositiveFemaleRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                false,
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Registration by positive scenario")
    @Description(value = "Registration with correct data, no gender selected")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testPositiveNoGenderRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Attempt to register with wrong first name")
    @Description(value = "Registration with empty first name input field")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void testNoFirstNameRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                "",
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkFirstNameErrorLabel(registrationPage.getFirstNameErrorLabel(), RegistrationLabels.FIRST_NAME_ERROR_LABEL.toString());
    }

    @Feature(value = "Registration with not standard first name by positive scenario")
    @Description(value = "Registration with Russian first name")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    public void testRussianFirstNameRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getRussianFirstName(),
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Registration with not standard first name by positive scenario")
    @Description(value = "Registration with letters + numbers first name")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    public void testFirstNameWithNumbersRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getNameWithNumbers(),
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Registration with not standard first name by positive scenario")
    @Description(value = "Registration with letters + special characters first name")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    public void testFirstNameWithSpecialCharactersRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getNameWithCharacters(),
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Attempt to register with wrong first name")
    @Description(value = "Registration with large first name (300 characters), this test should throw an exception")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(expectedExceptions = {Exception.class})
    public void testLargeFirstNameRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getLargeRandomString(),
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Attempt to register with wrong last name")
    @Description(value = "Registration with empty last name input field")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void testNoLastNameRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                dataGenerator.getValidFirstName(),
                "",
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkLastNameErrorLabel(registrationPage.getLastNameErrorLabel(), RegistrationLabels.LAST_NAME_ERROR_LABEL.toString());
    }

    @Feature(value = "Registration with not standard last name by positive scenario")
    @Description(value = "Registration with Russian last name")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    public void testRussianLastNameRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getRussianLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Registration with not standard last name by positive scenario")
    @Description(value = "Registration with letters + numbers last name")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    public void testLastNameWithNumbersRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getNameWithNumbers(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Registration with not standard first last by positive scenario")
    @Description(value = "Registration with letters + special characters last name")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    public void testLastNameWithSpecialCharactersRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getNameWithCharacters(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Attempt to register with wrong last name")
    @Description(value = "Registration with large last name (300 characters), this test should throw an exception")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(expectedExceptions = {Exception.class})
    public void testLargeLastNameRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getLargeRandomString(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Attempt to register with wrong email")
    @Description(value = "Registration with empty email input field")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void testNoEmailRegistration() {
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                "",
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkEmailErrorLabel(registrationPage.getEmailErrorLabel(), RegistrationLabels.EMAIL_REQUIRED_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to register with wrong email")
    @Description(value = "Registration with email that has wrong domen name (example: @gmail.ru)")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test(expectedExceptions = {Exception.class})
    public void testWrongDomenEmailRegistration() {
        String currentEmail = dataGenerator.getNormalRandomString() + WRONG_EMAIL_DOMEN;
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Attempt to register with wrong email")
    @Description(value = "Registration with email that already exists")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testEmailAlreadyExistsRegistration() {
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                REGISTERED_EMAIL,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkEmailAlreadyExistsErrorLabel(registrationPage.getEmailAlreadyExistsErrorLabel(), RegistrationLabels.EMAIL_ALREADY_EXISTS_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to register with wrong email")
    @Description(value = "Registration with random string in email input field")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void testRandomStringEmailRegistration() {
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                dataGenerator.getNormalRandomString(),
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkEmailErrorLabel(registrationPage.getEmailErrorLabel(), RegistrationLabels.WRONG_EMAIL_ERROR_LABEL.toString());
    }

    // сайт иногда падает при ручном проходе этого теста
    @Feature(value = "Attempt to register with wrong email")
    @Description(value = "Registration with large emil (300 characters), this test should throw an exception")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(expectedExceptions = {Exception.class})
    public void testLargeEmailRegistration() {
        String currentEmail = dataGenerator.getLargeEmail();
        String currentPassword = dataGenerator.getValidPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Attempt to register with wrong password")
    @Description(value = "Registration with empty (first) password input field")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void testNoFirstPasswordRegistration() {
        registrationPage.registerNewUser(
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                dataGenerator.getValidEmail(),
                "",
                dataGenerator.getValidPassword()
        );

        RegistrationTestSteps.checkPasswordErrorLabel(registrationPage.getPasswordErrorLabel(), RegistrationLabels.PASSWORD_ERROR_LABEL.toString());
        RegistrationTestSteps.checkConfirmPasswordErrorLabel(registrationPage.getConfirmPasswordErrorLabel(), RegistrationLabels.PASSWORD_MISMATCH_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to register with wrong password")
    @Description(value = "Registration with short password (less than 6 characters)")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testShortPasswordRegistration() {
        String currentPassword = dataGenerator.getShortPassword();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                dataGenerator.getValidEmail(),
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkPasswordErrorLabel(registrationPage.getPasswordErrorLabel(), RegistrationLabels.SHORT_PASSWORD_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to register with wrong password")
    @Description(value = "Registration with large password (300 characters), this test should throw an exception")
    @Severity(value = SeverityLevel.NORMAL)
    @Test(expectedExceptions = {Exception.class})
    public void testLargePasswordRegistration() {
        String currentEmail = dataGenerator.getValidEmail();
        String currentPassword = dataGenerator.getLargeRandomString();

        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                currentEmail,
                currentPassword,
                currentPassword
        );

        RegistrationTestSteps.checkSuccessfulRegistrationLabelStep(registrationPage.getSuccessfulRegistrationLabel(), RegistrationLabels.REGISTRATION_COMPLETED_TEXT.toString());

        registrationPage.clickContinueButton();

        RegistrationTestSteps.checkCurrentURLStep(driver.getCurrentUrl(), BASIC_URL);
        RegistrationTestSteps.checkEmailLabelStep(startPage.getEmailLabel(), currentEmail);
    }

    @Feature(value = "Attempt to register with wrong password")
    @Description(value = "Registration with confirm password that doesn't match first password")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void testPasswordNotMatchRegistration() {
        registrationPage.registerNewUser(
                true,
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                dataGenerator.getValidEmail(),
                dataGenerator.getValidPassword(),
                dataGenerator.getValidPassword()
        );

        RegistrationTestSteps.checkConfirmPasswordErrorLabel(registrationPage.getConfirmPasswordErrorLabel(), RegistrationLabels.PASSWORD_MISMATCH_ERROR_LABEL.toString());
    }

    @Feature(value = "Attempt to register with wrong password")
    @Description(value = "Registration with empty confirm password input field")
    @Severity(value = SeverityLevel.NORMAL)
    @Test
    public void testNoConfirmPasswordRegistration() {
        registrationPage.registerNewUser(
                dataGenerator.getValidFirstName(),
                dataGenerator.getValidLastName(),
                dataGenerator.getValidEmail(),
                dataGenerator.getValidPassword(),
                ""
        );

        RegistrationTestSteps.checkConfirmPasswordErrorLabel(registrationPage.getConfirmPasswordErrorLabel(), RegistrationLabels.PASSWORD_ERROR_LABEL.toString());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
