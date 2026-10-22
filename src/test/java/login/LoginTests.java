package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTests {
    @DataProvider
    public Object[][] testData() {
        return dataModel.getLogin1();
    }

    @Test(dataProvider = "testData")
    public void testMultipleLoginAccounts(String email, String password) {
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.loginFeature(email, password, 5);
      
    }
}
