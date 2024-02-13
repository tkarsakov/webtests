package com.solvd.webtests;

import com.solvd.webtests.mobile.entity.Item;
import com.solvd.webtests.mobile.modal.common.LogOutModalBase;
import com.solvd.webtests.mobile.pages.common.CartPageBase;
import com.solvd.webtests.mobile.pages.common.LogInPageBase;
import com.solvd.webtests.mobile.pages.common.MainPageBase;
import com.solvd.webtests.mobile.pages.common.ProductPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.Optional;

public class MyDemoAppTest implements IAbstractTest {

    private MainPageBase mainPageBase = null;

    private LogInPageBase logInPageBase = null;

    private ProductPageBase productPageBase = null;

    private CartPageBase cartPage = null;

    @BeforeTest
    public void setup() {
        mainPageBase = initPage(getDriver(), MainPageBase.class);
    }

    @Test
    public void testLogInAndLogOut() {
        logInPageBase = mainPageBase.getSideMenuModal().openSideMenu().clickLogIn();
        Assert.assertTrue(logInPageBase.isOpened());
        logInPageBase.typeUsername(R.TESTDATA.get("app_username"));
        logInPageBase.typePass(R.TESTDATA.get("pass"));
        Optional<MainPageBase> mainPageBaseOptional = logInPageBase.clickLogInButton();
        Assert.assertTrue(mainPageBaseOptional.isPresent());

        LogOutModalBase logOutModalBase = mainPageBase.getSideMenuModal().openSideMenu().clickLogOut();
        logOutModalBase.clickLogOut().clickOk();
        Assert.assertTrue(logInPageBase.isOpened());
    }

    @Test
    public void testLogInWithIncorrectPass() {
        logInPageBase = mainPageBase.getSideMenuModal().openSideMenu().clickLogIn();
        Assert.assertTrue(logInPageBase.isOpened());
        logInPageBase.typeUsername(R.TESTDATA.get("app_username"));
        logInPageBase.typePass("incorrect_pass");
        Optional<MainPageBase> mainPageBaseOptional = logInPageBase.clickLogInButton();
        Assert.assertTrue(mainPageBaseOptional.isEmpty());

        Assert.assertTrue(logInPageBase.isLogInErrorMessagePresent());
    }

    @Test
    public void testCompareItemFromStorePageAndProductPage() {
        Item itemFromStorePage = mainPageBase.getStoreItemByOrder(1);
        ProductPageBase productPageBase = mainPageBase.clickOnStoreItemByOrder(1);
        Assert.assertTrue(productPageBase.isPageOpened());

        Item itemFromProductPage = productPageBase.getItem();
        Assert.assertEquals(itemFromProductPage, itemFromStorePage);
    }

    @Test
    public void testAddItemsToCart() {
        productPageBase = mainPageBase.clickOnStoreItemByOrder(1);
        Assert.assertTrue(productPageBase.isPageOpened());
        Item firstItem = productPageBase.getItem();
        productPageBase.clickAddToCartButton();

        productPageBase.getSideMenuModal().openSideMenu().clickCatalog();

        productPageBase = mainPageBase.clickOnStoreItemByOrder(2);
        Assert.assertTrue(productPageBase.isPageOpened());
        Item secondItem = productPageBase.getItem();
        productPageBase.clickAddToCartButton();

        cartPage = productPageBase.getCartModal().clickCartButton();
        Item firstItemFromCart = cartPage.getItemByRow(1);
        Item secondItemFromCart = cartPage.getItemByRow(2);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstItem, firstItemFromCart);
        softAssert.assertEquals(secondItem, secondItemFromCart);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testAddItemsToCart")
    public void testRemoveItemsFromCart() {
        Item firstItemFromCart = cartPage.getItemByRow(1);
        Item secondItemFromCart = cartPage.getItemByRow(2);
        BigDecimal totalBeforeOperations = cartPage.getTotalPrice();
        Assert.assertEquals(firstItemFromCart.getItemPrice().add(secondItemFromCart.getItemPrice()), totalBeforeOperations);

        cartPage.clickRemoveItemByRow(1);
        Assert.assertEquals(totalBeforeOperations.subtract(firstItemFromCart.getItemPrice()), cartPage.getTotalPrice());

        cartPage.clickRemoveItemByRow(1);
        Assert.assertTrue(cartPage.isCartEmpty());
    }
}
