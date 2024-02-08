package com.solvd.webtests;

import com.solvd.webtests.web.pages.CartPage;
import com.solvd.webtests.web.pages.ProductPage;
import com.solvd.webtests.web.pages.StorePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class SteamStoreTest implements IAbstractTest {

    private StorePage storePage = null;

    @BeforeSuite
    public void startDriverAndOpenMainPage() {
        storePage = new StorePage(getDriver());
        storePage.open();
    }

    @Test
    public void testOpenPage() {
        Assert.assertTrue(storePage.isPageOpened());
    }

    @Test(expectedExceptions = ElementNotInteractableException.class)
    public void testClickCartButtonWithoutAddingItems() {
        storePage.getCartButtonComponent().clickCartButton();
    }

    @Test
    public void testAddItemFromSearchToCart() {
        String firstGame = R.TESTDATA.get("search_game1");
        String secondGame = R.TESTDATA.get("search_game2");

        ProductPage productPage = storePage.getStoreNavComponent()
                .searchAndClickItemInResults(firstGame);
        CartPage cartPage = productPage.clickAddToCartButton();
        cartPage.getStoreNavComponent().searchAndClickItemInResults(secondGame);
        productPage.clickAddToCartButton();
        
        List<String> names = cartPage.getItemNames();
        Assert.assertTrue(names.contains(firstGame));
        Assert.assertTrue(names.contains(secondGame));
    }
}
