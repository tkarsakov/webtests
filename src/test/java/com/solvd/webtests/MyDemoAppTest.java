package com.solvd.webtests;

import com.solvd.webtests.mobile.pages.common.MainPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyDemoAppTest implements IAbstractTest {

    private MainPageBase mainPageBase = null;

    @BeforeTest
    public void setup() {
        mainPageBase = initPage(getDriver(), MainPageBase.class);
    }

    @Test
    public void testClickCartButton() {
        mainPageBase.getStoreItemByOrder(1);
    }
}