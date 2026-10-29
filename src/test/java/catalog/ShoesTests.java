package catalog;

import base.BaseTests;
import data.DataModel;
import data.shoesItem.ShoesItemDataModel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ShoesPage;

import java.util.List;

public class ShoesTests extends BaseTests {
    @DataProvider
    public Object[][] getShoesDataOption() {

        List<ShoesItemDataModel> shoesItemDataModels = dataModel.getShoesCustomization().getValidData();
        Object[][] data = new Object[shoesItemDataModels.size()][5];
        for (int i = 0; i < shoesItemDataModels.size(); i++) {
            data[i][0] = shoesItemDataModels.get(i).getTestCase();
            data[i][1] = shoesItemDataModels.get(i).getSize();
            data[i][2] = shoesItemDataModels.get(i).getColor();
            data[i][3] = shoesItemDataModels.get(i).getPrint();
            data[i][4] = shoesItemDataModels.get(i).getExpectedResult();
        }
        return data;
    }

    @Test(dataProvider = "getShoesDataOption")
    public void testShoesOption(String testCase, String size, String color, String print, String expectedResult) {
        System.out.println("Running Test Case: " + testCase);
        System.out.println("Data -> Size: " + size + " | Color: " + color + " | Print: " + print);
        ShoesPage shoesPage = homePage.clickOnApparelLink(20);
        shoesPage.clickOnProductNikeSb(20);
        shoesPage.configureShoeOptions(size, color, print, 20);
        shoesPage.clickOnAddToCart(20);
        String actualResult = shoesPage.assertNotificationContains(expectedResult, 20); // (تأكد أن الميثود دي موجودة عندك أو في MethodHandles)
        System.out.println("Actual Result from Page: " + actualResult);
        Assert.assertTrue(actualResult.contains(expectedResult),
                "Test Failed for: " + testCase + " | Expected to contain: " + expectedResult + " | But got: " + actualResult);
    }
}