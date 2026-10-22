package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class ItemInformationPage extends MethodHandles {
    public ItemInformationPage(WebDriver driver) {
        super(driver);
    }

    // locator
    private final By addToCartBtn = By.id("add-to-cart-button-3");

    //Actions
    public void clickOnAddToCartBtn() {
        click(addToCartBtn, 5);
    }
}
