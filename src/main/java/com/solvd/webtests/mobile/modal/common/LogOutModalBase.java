package com.solvd.webtests.mobile.modal.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class LogOutModalBase extends AbstractPage {
    public LogOutModalBase(WebDriver driver) {
        super(driver);
    }

    public LogOutModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract LogOutConfirmationModalBase clickLogOut();
}
