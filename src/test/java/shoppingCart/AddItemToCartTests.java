package shoppingCart;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DesktopPage;
import pages.ItemInformationPage;

public class AddItemToCartTests extends BaseTests {

    @Test
    public void testNotificationSuccess() {
        DesktopPage desktopPage = homePage.openDesktopUnderComputers(15);
        ItemInformationPage itemInformationPage = desktopPage.clickOnLenovoIdeaLink();
        itemInformationPage.clickOnAddToCartBtn();
        itemInformationPage.assertNotificationContains("The product has been added to your", 10);
    }
}
