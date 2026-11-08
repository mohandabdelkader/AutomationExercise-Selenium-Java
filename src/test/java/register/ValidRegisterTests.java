package register;

import base.BaseTests;
import data.registerDataModel.ValidDataRegister;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegisterPage;
import reader.TestDataManger;

public class ValidRegisterTests extends BaseTests {
    @DataProvider
    public Object[][] getValidDataRegister() {
        ValidDataRegister validDataRegister = TestDataManger.getRegisterData().getValidDataRegister();
        return new Object[][]{
                {validDataRegister}
        };
    }

    @Test(dataProvider = "getValidDataRegister")
    public void testValidRegisterData(ValidDataRegister data) {
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
