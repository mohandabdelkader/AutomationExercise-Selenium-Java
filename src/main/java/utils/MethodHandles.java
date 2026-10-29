package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {
    protected WebDriverWait wait;
    protected WebDriver driver;
    Actions actions;
    Select select;

    public MethodHandles(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // locator And Wait
    protected WebElement webElement(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    // Click

    public void click(By locator, int time) {
        webElement(locator, time).click();
    }

    // Send Keys
    public void sendKeys(String text, By locator, int time) {
        WebElement element = webElement(locator, time);
        element.clear();
        element.sendKeys(text);
    }

    // Hover
    public void hover(By locator, int time) {
        actions.moveToElement(webElement(locator, time)).build().perform();
    }

    public void selectByVisibleText(By locator, int time, String text) {
        select = new Select(webElement(locator, time));
        select.selectByVisibleText(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Notification
    private static final By successNotification = By.cssSelector(".bar-notification.success");

    public String assertNotificationContains(String expectedText, int time) {
        assertNotificationContains(expectedText, successNotification, time);
        return expectedText;
    }

    public void assertNotificationContains(String expectedText, By notificationLocator, int time) {
        String actual = webElement(notificationLocator, time).getText();
        if (!actual.contains(expectedText)) {
            throw new AssertionError(
                    "Expected notification to contain: \"" + expectedText + "\" but was: \"" + actual + "\""
            );
        }
    }

}
