package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MethodHandles;

import java.time.Duration;

public class ShoppingCartPage extends MethodHandles {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    // locator
    private final By cartQty = By.cssSelector(".cart-qty");
    private final By cartLabel = By.cssSelector(".cart-label");

    //Actions
// fo change value (Assert Value)
    public int waitForCartQty(int time, int expectedResult) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(d -> getCartQty(time) == expectedResult);
        return expectedResult;
    }
// get actual result and type casting Integer
    public int getCartQty(int time) {
        hover(cartLabel, time);
        String actualResult = webElement(cartQty, time).getText();
        actualResult = actualResult.replace("(", "").replace(")", "").trim();
        if (actualResult.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(actualResult);

    }

}
