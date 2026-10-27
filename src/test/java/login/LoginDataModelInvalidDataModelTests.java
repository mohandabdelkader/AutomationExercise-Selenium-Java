package login;

import base.BaseTests;
import data.login.InvalidDataModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.List;

public class LoginDataModelInvalidDataModelTests extends BaseTests {
    @DataProvider
    public Object[][] getInvalidData() {
        List<InvalidDataModel> invalidDatumModels = dataModel.getLogin().getInvalidData();
        Object[][] data = new Object[invalidDatumModels.size()][4];

        for (int i = 0; i < invalidDatumModels.size(); i++) {
            data[i][0] = invalidDatumModels.get(i).getTestCase();
            data[i][1] = invalidDatumModels.get(i).getEmail();
            data[i][2] = invalidDatumModels.get(i).getPassword();
            data[i][3] = invalidDatumModels.get(i).getExpectedMessage();
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
            actualResult = loginPage.getGeneralErrorMessage(20);
        }
        System.out.println("Actual Result: " + actualResult);
        System.out.println("Expected Result: " + expectedMessage);
        Assert.assertTrue(
                actualResult.contains(expectedMessage),
                "Expected message to contain: \"" + expectedMessage + "\" but was: \"" + actualResult + "\""
        );
    }
}
