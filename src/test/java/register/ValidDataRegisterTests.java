package register;

import base.BaseTests;
import data.register.ValidRegisterDataModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class ValidDataRegisterTests extends BaseTests {
    @DataProvider
    public Object[][] getValidDataRegister() {
        ValidRegisterDataModel validRegisterDataModel = dataModel.getRegister().getValidData();
        return new Object[][]{
                {validRegisterDataModel}
        };
    }

    @Test(dataProvider = "getValidDataRegister")
    public void testValidRegisterData(ValidRegisterDataModel data) {
        RegisterPage registerPage = homePage.openRegisterLink(20);
        System.out.println("test cases " + data.getTestCase());
        registerPage.registerFeature(
                data.getGender(),
                data.getFirstName(),
                data.getLastName(),
                data.getEmail(),
                data.getPassword(),
                data.getConfirmPassword(),
                20
        );
        String actual = registerPage.getRegistrationResultMessage(20);
        Assert.assertTrue(
                actual.contains(data.getExpectedMessage()),
                "Expected message to contain: \"" + data.getExpectedMessage() + "\" but was: \"" + actual + "\""
        );
    }
}
