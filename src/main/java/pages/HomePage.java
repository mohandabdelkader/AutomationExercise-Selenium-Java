package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

    private final By signupLoginLink = By.cssSelector(".ico-login");
    private final By logoutLink = By.cssSelector("a.ico-logout");
    private final By computersMenu = By.cssSelector("a[href='/computers']");
    private final By desktopLink = By.cssSelector("a[href='/desktops']");
    private final By shoppingCartLink = By.cssSelector(".cart-label");
    private final By registerLink = By.linkText("Register");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        if (!driver.findElements(logoutLink).isEmpty()) {
            click(logoutLink, 10);
        }
        click(signupLoginLink, 10);
        return new LoginPage(driver);
    }

    public DesktopPage openDesktopUnderComputers(int time) {
        hover(computersMenu, time);
        click(desktopLink, time);
        return new DesktopPage(driver);
    }

    public ShoppingCartPage openShoppingCartLink(int time) {
        click(shoppingCartLink, time);
        return new ShoppingCartPage(driver);
    }

    public RegisterPage openRegisterLink(int time) {
        click(registerLink, time);
        return new RegisterPage(driver);
    }

}
