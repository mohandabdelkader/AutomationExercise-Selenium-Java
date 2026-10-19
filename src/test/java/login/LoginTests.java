package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTests {

    @Test
    public void testValidData() {
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.loginFeature(
                dataModel.login.validData.username,
                dataModel.login.validData.password,
                10
        );
        Assert.assertTrue(driver.getPageSource().contains("Logout"));
    }
}
