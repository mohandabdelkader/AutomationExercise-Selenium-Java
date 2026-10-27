package login;

import base.BaseTests;
import data.login.ValidDataModel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginDataModelValidDataModelTests extends BaseTests {

    @DataProvider(name = "validLoginDataProvider")
    public Object[][] getValidLoginData() {
        ValidDataModel validDataModel = dataModel.getLogin().getValidData();
        return new Object[][]{
                {
                        validDataModel.getTestCase(),
                        validDataModel.getEmail(),
                        validDataModel.getPassword(),
                        validDataModel.getExpectedResult()
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
