package catalog;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesktopTests extends BaseTests {

    @Test
    public void testOpenDesktopFromComputerMenu() {
        homePage.openDesktopUnderComputers(10);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Desktops", "Error: The desktop page title is incorrect!");
    }
}
