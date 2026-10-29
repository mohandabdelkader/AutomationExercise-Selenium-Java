package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.MethodHandles;

public class ShoesPage extends MethodHandles {
    public ShoesPage(WebDriver driver) {
        super(driver);
    }

    // locators
    private final By productNikeSb = By.cssSelector("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000051_nike-floral-roshe-customized-running-shoes_415.jpeg\"]");
    private final By sizeSelect = By.id("product_attribute_6");
    private final By colorSelect = By.id("product_attribute_7");
    private final By printOne = By.cssSelector("span[style*='0000053_natural_32.jpeg']");
    private final By printTwo = By.cssSelector("span[style*='0000054_fresh_32.jpeg']");
    private final By addToCartBtn = By.id("add-to-cart-button-26");

    // Actions
    public void clickOnProductNikeSb(int time) {
        click(productNikeSb, time);
    }

    private void selectPrint(String printChose, int time) {
        if (printChose.equalsIgnoreCase("print1")) {
            click(printOne, time);
        } else {
            click(printTwo, time);
        }
    }

    public void configureShoeOptions(String sizeText, String colorText, String printChose, int time) {
        selectByVisibleText(sizeSelect, time, sizeText);
        selectByVisibleText(colorSelect, time, colorText);
        selectPrint(printChose, time);
    }

    public void clickOnAddToCart(int time) {
        WebElement cartBtn = webElement(addToCartBtn, time);
        scrollToElement(cartBtn);
        click(addToCartBtn, time);
    }
}