package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class RegisterPage extends MethodHandles {

    private final By genderMale = By.id("gender-male");
    private final By genderFemale = By.id("gender-female");
    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By confirmPasswordField = By.id("ConfirmPassword");
    private final By registerButton = By.id("register-button");
    private final By registrationResult = By.cssSelector(".result");
    private final By firstNameError = By.cssSelector("span.field-validation-error[data-valmsg-for='FirstName']");
    private final By passwordMismatchError = By.cssSelector("span.field-validation-error[data-valmsg-for='ConfirmPassword']");
    private final By exitedEmailError = By.xpath("//li[contains(text(), 'The specified email already exists')]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerFeature(
            String gender,
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword,
            int time
    ) {
        selectGender(gender, time);
        sendKeys(firstName, firstNameField, time);
        sendKeys(lastName, lastNameField, time);
        sendKeys(email, emailField, time);
        sendKeys(password, passwordField, time);
        sendKeys(confirmPassword, confirmPasswordField, time);
        click(registerButton, time);
    }

    private void selectGender(String gender, int time) {
        if (gender == null || gender.isEmpty()) {
            return;
        }
        if ("Male".equalsIgnoreCase(gender)) {
            click(genderMale, time);
        } else if ("Female".equalsIgnoreCase(gender)) {
            click(genderFemale, time);
        }
    }

    public String getRegistrationResultMessage(int time) {
        return webElement(registrationResult, time).getText();
    }

    public String getExitedErrorMessage(int time) {
        return webElement(exitedEmailError, time).getText();
    }

    public String getFirstNameErrorMessage(int time) {
        return webElement(firstNameError, time).getText();
    }

    public String getConfirmPasswordErrorMessage(int time) {
        return webElement(passwordMismatchError, time).getText();
    }
}
