package com.solvd.webtests;

import com.solvd.webtests.web.entity.ExpectedSearchResult;
import com.solvd.webtests.web.entity.Product;
import com.solvd.webtests.web.pages.*;
import com.solvd.webtests.web.pages.common.Locale;
import com.solvd.webtests.web.service.LocaleService;
import com.solvd.webtests.web.service.ScrollingService;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

public class SteamStoreTest implements IAbstractTest {

    private final List<Product> products = new ArrayList<>();
    private StorePage storePage = null;
    private CartPage cartPage = null;
    private ProductPage productPage = null;

    @BeforeTest
    public void setup() {
        storePage = new StorePage(getDriver());
        storePage.open();
        LocaleService.setBothLocaleAndBrowserLocaleInConfig(Locale.EN);

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
        Integer order = R.TESTDATA.getInt("order");
        Product productOnStorePage = storePage.getProductFromContentTab(ContentTab.newreleases, order);
        productPage = storePage.clickOnPaidGameInContentTab(ContentTab.newreleases, order);
        softAssert.assertTrue(productPage.isPageOpened());
        softAssert.assertEquals(productOnStorePage.getProductName(), productPage.getProductNameString());
        softAssert.assertEquals(productOnStorePage.getProductPrice(), productPage.getProductPrice());
        softAssert.assertAll();
    }

    @Test
    public void testPagesAreScrollable() {
        SoftAssert softAssert = new SoftAssert();
        Long scrollAmount = R.TESTDATA.getLong("scrollAmount");

        ScrollingService.scrollDown(scrollAmount, getDriver());
        softAssert.assertEquals(ScrollingService.getScrollingPosition(getDriver()), scrollAmount);

        productPage = storePage.clickOnPaidGameInContentTab(ContentTab.newreleases, R.TESTDATA.getInt("order"));
        ScrollingService.scrollDown(scrollAmount, getDriver());
        softAssert.assertEquals(ScrollingService.getScrollingPosition(getDriver()), scrollAmount);

        cartPage = productPage.clickAddToCartButton();
        softAssert.assertTrue(cartPage.isPageOpened());
        ScrollingService.scrollDown(scrollAmount, getDriver());
        softAssert.assertEquals(ScrollingService.getScrollingPosition(getDriver()), scrollAmount);
        softAssert.assertAll();
    }

    @Test
    public void testSearchResults() {
        SoftAssert softAssert = new SoftAssert();
        ExpectedSearchResult expectedSearchResult1 = new ExpectedSearchResult(R.TESTDATA.get("game2"));
        expectedSearchResult1.addSearchResults(
                new AbstractMap.SimpleEntry<>(R.TESTDATA.get("searchResult1forGame2"), 1),
                new AbstractMap.SimpleEntry<>(R.TESTDATA.get("searchResult2forGame2"), 2));
        ExpectedSearchResult expectedSearchResult2 = new ExpectedSearchResult(R.TESTDATA.get("game3"));
        expectedSearchResult2.addSearchResults(
                new AbstractMap.SimpleEntry<>(R.TESTDATA.get("searchResult1forGame3"), 1),
                new AbstractMap.SimpleEntry<>(R.TESTDATA.get("searchResult2forGame3"), 2));

        SearchResultPage searchResultPage = storePage.getStoreNavComponent().typeSearchPhrase(expectedSearchResult1.getSearchTerm()).clickSearchButton();
        softAssert.assertTrue(searchResultPage.isExpectedResultCorrect(expectedSearchResult1));

        searchResultPage.getStoreNavComponent().typeSearchPhrase(expectedSearchResult2.getSearchTerm()).clickSearchButton();
        softAssert.assertTrue(searchResultPage.isExpectedResultCorrect(expectedSearchResult2));
        softAssert.assertAll();
    }
}
