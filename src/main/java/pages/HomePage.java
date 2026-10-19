package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

    private final By signupLoginLink = By.linkText("Signup / Login");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        click(signupLoginLink, 10);
        return new LoginPage(driver);
    }
}
