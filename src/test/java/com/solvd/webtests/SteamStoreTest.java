package com.solvd.webtests;

import com.solvd.webtests.web.pages.StorePage;
import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
}
