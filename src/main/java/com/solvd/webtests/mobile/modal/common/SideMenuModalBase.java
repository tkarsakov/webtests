package com.solvd.webtests.mobile.modal.common;

import com.solvd.webtests.mobile.pages.common.LogInPageBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class SideMenuModalBase extends AbstractPage {

    public SideMenuModalBase(WebDriver driver) {
        super(driver);
    }

    public SideMenuModalBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public abstract SideMenuModalBase openSideMenu();

    public abstract LogInPageBase clickLogIn();

    public abstract LogOutConfirmationModalBase clickLogOut();
}
