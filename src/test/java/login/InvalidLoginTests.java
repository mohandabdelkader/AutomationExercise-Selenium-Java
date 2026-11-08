package login;

import base.BaseTests;
import data.loginDataModel.InvalidDataLogin;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.TestDataManger;

import java.util.List;

public class InvalidLoginTests extends BaseTests {
    @DataProvider
    public Object[][] getInvalidData() {
        List<InvalidDataLogin> invalidDataLogin = TestDataManger.getLoginData().getInvalidData();
        Object[][] data = new Object[invalidDataLogin.size()][4];

        for (int i = 0; i < invalidDataLogin.size(); i++) {
            data[i][0] = invalidDataLogin.get(i).getTestCase();
            data[i][1] = invalidDataLogin.get(i).getEmail();
            data[i][2] = invalidDataLogin.get(i).getPassword();
            data[i][3] = invalidDataLogin.get(i).getExpectedMessage();
        }
        return data;
    }

    @Test(dataProvider = "getInvalidData")
    public void testInvalidEmail(String testcase, String email, String password, String expectedMessage) {
        LoginPage loginPage = homePage.openLoginPage();
        System.out.println("test case: " + testcase);
        loginPage.loginFeature(email, password, 20);
        String actualResult;
        if (testcase.contains("Email")) {
            actualResult = loginPage.getEmailFormatErrorMessage(20);
        } else {
            actualResult = loginPage.getLoginMessageError(30);
        }
        System.out.println("Actual Result: " + actualResult);
        System.out.println("Expected Result: " + expectedMessage);
        Assert.assertTrue(
                actualResult.contains(expectedMessage),
                "Expected message to contain: \"" + expectedMessage + "\" but was: \"" + actualResult + "\""
        );
    }
}
