package login;

import base.BaseTests;
import data.loginDataModel.ValidDataLogin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.TestDataManger;

public class ValidLoginTests extends BaseTests {

    @DataProvider(name = "validLoginDataProvider")
    public Object[][] getValidLoginData() {
        ValidDataLogin validDataLogin = TestDataManger.getLoginData().getValidData();
        return new Object[][]{
                {
                        validDataLogin.getTestCase(),
                        validDataLogin.getEmail(),
                        validDataLogin.getPassword(),
                        validDataLogin.getExpectedResult()
                }
        };
    }

    @Test(dataProvider = "validLoginDataProvider")
    public void testValidData(String testCase, String email, String password, String expectedResult) {
        LoginPage loginPage = homePage.openLoginPage();
        System.out.println("test case : " + testCase);
        loginPage.loginFeature(email, password, 20);
    }
}
