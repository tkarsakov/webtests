package com.solvd.webtests;

import com.solvd.webtests.web.pages.StorePage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SteamStoreTest implements IAbstractTest {

    private StorePage storePage = null;

    @BeforeSuite
    public void startDriver() {
        storePage = new StorePage(getDriver());
    }

    @Test
    public void testOpenPage() {
        storePage.open();
        Assert.assertTrue(storePage.isPageOpened());
    }
}
