package com.solvd.webtests.mobile.modal.common;

import com.solvd.webtests.mobile.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class CartModalBase extends AbstractPage {
    public CartModalBase(WebDriver driver) {
        super(driver);
    }

    public CartModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract CartPageBase clickCartButton();
}
