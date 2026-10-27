package shoppingCart;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DesktopPage;
import pages.ItemInformationPage;
import pages.ShoppingCartPage;

public class ShoppingCartCountTests extends BaseTests {
    @Test
    public void testShoppingCartQty() {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        // 1- read cart before add item
        int before = shoppingCartPage.getCartQty(10);
// 2- add item
        DesktopPage desktopPage = homePage.openDesktopUnderComputers(10);
        ItemInformationPage itemInformationPage = desktopPage.clickOnLenovoIdeaLink();
        itemInformationPage.clickOnAddToCartBtn();
        // Assert
        itemInformationPage.assertNotificationContains("The product has been added to your", 10);
// read after add item
        int expectedResult = before + 1;
        int after = shoppingCartPage.waitForCartQty(25, expectedResult);
        System.out.println("before = " + before);
        System.out.println("after = " + after);
        System.out.println("expected = " + expectedResult);
        Assert.assertEquals(after, expectedResult);
    }

}
