package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {

    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By loginBtn = By.cssSelector(".button-1.login-button");
    private final By emailFormatError = By.cssSelector("span.field-validation-error[data-valmsg-for='Email']");
    private final By loginFailureSummary = By.cssSelector(".message-error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginFeature(String email, String password, int time) {
        sendKeys(email, emailField, time);
        sendKeys(password, passwordField, time);
        click(loginBtn, time);
    }
    public String getEmailFormatErrorMessage(int time) {
        return webElement(emailFormatError, time).getText();
    }

    public String getGeneralErrorMessage(int time) {
        return webElement(loginFailureSummary, time).getText();
    }
}
