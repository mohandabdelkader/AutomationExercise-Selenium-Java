package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class DesktopPage extends MethodHandles {


    public DesktopPage(WebDriver driver) {
        super(driver);
    }

    // locator
    private final By lenovoIdeaCentreLink = By.linkText("Lenovo IdeaCentre");

    // Actions
    public ItemInformationPage clickOnLenovoIdeaLink() {
        click(lenovoIdeaCentreLink, 5);
        return new ItemInformationPage(driver);
    }

}
