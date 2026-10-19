package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {

    private final By emailField = By.cssSelector("[data-qa='login-email']");
    private final By passwordField = By.cssSelector("[data-qa='login-password']");
    private final By loginBtn = By.cssSelector("[data-qa='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginFeature(String email, String password, int time) {
        sendKeys(email, emailField, time);
        sendKeys(password, passwordField, time);
        click(loginBtn, time);
    }
}
