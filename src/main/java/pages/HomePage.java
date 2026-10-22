package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

    private final By signupLoginLink = By.cssSelector(".ico-login");
    private final By computersMenu = By.cssSelector("a[href='/computers']");
    private final By desktopLink = By.cssSelector("a[href='/desktops']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        click(signupLoginLink, 10);
        return new LoginPage(driver);
    }

    public DesktopPage openDesktopUnderComputers(int time) {
        hover(computersMenu, time);
        click(desktopLink, time);
        return new DesktopPage(driver);
    }
}
