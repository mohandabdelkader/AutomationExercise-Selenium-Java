package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.HomePage;
import reader.TestDataManger;

import java.io.FileNotFoundException;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browserName) throws FileNotFoundException {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--healdess");
            driver = new FirefoxDriver(options);
        }
    }

    public void returnHome() {
        driver.get(TestDataManger.getConfigData().getURL());
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHomeBeforeTest() {
        returnHome();
    }

    @AfterMethod
    public void goHomeAfterTest() {
        returnHome();
    }

    @AfterClass
    public void tearDown() {
        driver = null;
    }
}
