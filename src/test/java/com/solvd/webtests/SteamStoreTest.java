package com.solvd.webtests;

import com.solvd.webtests.web.entity.Product;
import com.solvd.webtests.web.pages.CartPage;
import com.solvd.webtests.web.pages.ContentTab;
import com.solvd.webtests.web.pages.ProductPage;
import com.solvd.webtests.web.pages.StorePage;
import com.solvd.webtests.web.service.LocaleService;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SteamStoreTest implements IAbstractTest {

    private StorePage storePage = null;
    private CartPage cartPage = null;
    private ProductPage productPage = null;
    private List<Product> products = new ArrayList<>();

    @BeforeTest
    public void setup() {
        storePage = new StorePage(getDriver());
        storePage.open();
        LocaleService.setLocaleInConfig(storePage.getLocale());
    }

    @Test
    public void testAddTwoItemsToCartFromSearch() {
        SoftAssert softAssert = new SoftAssert();
        String firstGameName = R.TESTDATA.get("game1");
        String secondGameName = R.TESTDATA.get("game2");

        productPage = storePage.getStoreNavComponent()
                .typeSearchPhrase(firstGameName)
                .clickOnItemInSearchResultsByName(firstGameName);
        products.add(new Product(productPage.getProductNameString(), productPage.getProductPrice()));
        cartPage = productPage.clickAddToCartButton();

        cartPage.getStoreNavComponent()
                .typeSearchPhrase(secondGameName)
                .clickOnItemInSearchResultsByName(secondGameName);
        products.add(new Product(productPage.getProductNameString(), productPage.getProductPrice()));
        productPage.clickAddToCartButton();

        List<String> names = cartPage.getItemNames();
        BigDecimal totalFromPages = products.get(0).getProductPrice().add(products.get(1).getProductPrice());
        BigDecimal cartTotal = cartPage.getEstimatedTotal();
        softAssert.assertTrue(names.contains(firstGameName));
        softAssert.assertTrue(names.contains(secondGameName));
        softAssert.assertEquals(totalFromPages, cartTotal);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testAddTwoItemsToCartFromSearch")
    public void testRemoveItemsFromCart() {
        SoftAssert softAssert = new SoftAssert();
        BigDecimal cartTotalBeforeRemoval = cartPage.getEstimatedTotal();
        cartPage.removeItemFromCartByName(products.get(0).getProductName());
        softAssert.assertEquals(cartTotalBeforeRemoval.subtract(cartPage.getEstimatedTotal()), products.get(0).getProductPrice());

        cartTotalBeforeRemoval = cartPage.getEstimatedTotal();
        cartPage.removeItemFromCartByName(products.get(1).getProductName());
        softAssert.assertEquals(cartTotalBeforeRemoval.subtract(cartPage.getEstimatedTotal()), products.get(0).getProductPrice());
        softAssert.assertTrue(cartPage.getItemNames().isEmpty());
        softAssert.assertAll();
    }

    @Test
    public void testCompareProductOnStorePageAndProductPage() {
        SoftAssert softAssert = new SoftAssert();
        Integer order = 1;
        Product productOnStorePage = storePage.getProductFromContentTab(ContentTab.newreleases, order);
        productPage = storePage.clickOnPaidGameInContentTab(ContentTab.newreleases, order);
        softAssert.assertTrue(productPage.isPageOpened());
        softAssert.assertEquals(productOnStorePage.getProductName(), productPage.getProductNameString());
        softAssert.assertEquals(productOnStorePage.getProductPrice(), productPage.getProductPrice());
    }
}
