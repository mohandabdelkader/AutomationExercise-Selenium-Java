package register;

import base.BaseTests;
import data.register.InValidRegisterDataModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.util.List;

public class InvalidDataRegisterTests extends BaseTests {

    @DataProvider
    public Object[][] getInvalidData() {
        List<InValidRegisterDataModel> invalidRows = dataModel.getRegister().getInvalidData();
        Object[][] data = new Object[invalidRows.size()][8];

        for (int i = 0; i < invalidRows.size(); i++) {
            data[i][0] = invalidRows.get(i).getTestCase();
            data[i][1] = invalidRows.get(i).getGender();
            data[i][2] = invalidRows.get(i).getFirstName();
            data[i][3] = invalidRows.get(i).getLastName();
            data[i][4] = invalidRows.get(i).getEmail();
            data[i][5] = invalidRows.get(i).getPassword();
            data[i][6] = invalidRows.get(i).getConfirmPassword();
            data[i][7] = invalidRows.get(i).getExpectedMessage();
        }
        return data;
    }

    @Test(dataProvider = "getInvalidData")
    public void testInvalidRegisterData(
            String testCase,
            String gender,
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword,
            String expectedMessage
    ) {
        RegisterPage registerPage = homePage.openRegisterLink(20);
        System.out.println("test case: " + testCase);
        registerPage.registerFeature(
                gender,
                firstName,
                lastName,
                email,
                password,
                confirmPassword,
                20
        );

        String actualResult;
        if (testCase.contains("Password")) {
            actualResult = registerPage.getConfirmPasswordErrorMessage(20);
        } else if (testCase.contains("email already exists")) {
            actualResult = registerPage.getExitedErrorMessage(20);

        } else {
            actualResult = registerPage.getFirstNameErrorMessage(20);
        }

        System.out.println("Actual Result: " + actualResult);
        System.out.println("Expected Result: " + expectedMessage);
        Assert.assertTrue(
                actualResult.contains(expectedMessage),
                "Expected message to contain: \"" + expectedMessage + "\" but was: \"" + actualResult + "\""
        );
    }
}
