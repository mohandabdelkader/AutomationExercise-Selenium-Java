package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import reader.TestDataManger;

import java.io.FileNotFoundException;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() throws FileNotFoundException {


        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);
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
