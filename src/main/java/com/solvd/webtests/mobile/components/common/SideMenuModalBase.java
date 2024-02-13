package com.solvd.webtests.mobile.components.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class SideMenuModalBase extends AbstractPage {

    public SideMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public SideMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }
}
