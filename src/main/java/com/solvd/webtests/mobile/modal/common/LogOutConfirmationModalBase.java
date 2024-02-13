package com.solvd.webtests.mobile.modal.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class LogOutConfirmationModalBase extends AbstractPage {
    public LogOutConfirmationModalBase(WebDriver driver) {
        super(driver);
    }

    public LogOutConfirmationModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }
}
