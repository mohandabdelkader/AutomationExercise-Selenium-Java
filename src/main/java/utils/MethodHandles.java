package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {
    protected WebDriverWait wait;
    protected WebDriver driver;

    public MethodHandles(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement webElement(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void click(By locator, int time) {
        webElement(locator, time).click();
    }

    public void sendKeys(String text, By locator, int time) {
        WebElement element = webElement(locator, time);
        element.clear();
        element.sendKeys(text);
    }

    public void selectByVisibleText(By locator, int time, String visibleText) {
        WebElement element = webElement(locator, time);
        new Select(element).selectByVisibleText(visibleText);
    }
}
