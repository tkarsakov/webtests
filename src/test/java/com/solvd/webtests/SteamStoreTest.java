package com.solvd.webtests;

import com.solvd.webtests.web.entity.Product;
import com.solvd.webtests.web.pages.CartPage;
import com.solvd.webtests.web.pages.ProductPage;
import com.solvd.webtests.web.pages.StorePage;
import com.solvd.webtests.web.service.LocaleService;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    public void testAddTwoItemsFromSearch() {
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
        Assert.assertTrue(names.contains(firstGameName));
        Assert.assertTrue(names.contains(secondGameName));
        Assert.assertEquals(totalFromPages, cartTotal);
    }

    @Test(dependsOnMethods = "testAddTwoItemsFromSearch")
    public void testRemoveItemsFromCart() {
        BigDecimal cartTotalBeforeRemoval = cartPage.getEstimatedTotal();
        cartPage.removeItemFromCartByName(products.get(0).getProductName());
        Assert.assertEquals(cartTotalBeforeRemoval.subtract(cartPage.getEstimatedTotal()), products.get(0).getProductPrice());

        cartTotalBeforeRemoval = cartPage.getEstimatedTotal();
        cartPage.removeItemFromCartByName(products.get(1).getProductName());
        Assert.assertEquals(cartTotalBeforeRemoval.subtract(cartPage.getEstimatedTotal()), products.get(0).getProductPrice());
    }
}
