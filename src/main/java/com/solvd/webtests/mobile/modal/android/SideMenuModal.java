package com.solvd.webtests.mobile.modal.android;

import com.solvd.webtests.mobile.modal.common.LogOutConfirmationModalBase;
import com.solvd.webtests.mobile.modal.common.SideMenuModalBase;
import com.solvd.webtests.mobile.pages.common.LogInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SideMenuModalBase.class)
public class SideMenuModal extends SideMenuModalBase {

    @ExtendedFindBy(accessibilityId = "open menu")
    private ExtendedWebElement sideMenuButton;

    @ExtendedFindBy(accessibilityId = "menu item log in")
    private ExtendedWebElement logInMenuItem;

    @ExtendedFindBy(accessibilityId = "menu item log out")
    private ExtendedWebElement logOutMenuItem;

    public SideMenuModal(WebDriver driver) {
        super(driver);
    }

    public SideMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    @Override
    public SideMenuModalBase openSideMenu() {
        sideMenuButton.click();
        return initPage(driver, SideMenuModalBase.class);
    }

    @Override
    public LogInPageBase clickLogIn() {
        logInMenuItem.click();
        return initPage(driver, LogInPageBase.class);
    }

    @Override
    public LogOutConfirmationModalBase clickLogOut() {
        logOutMenuItem.click();
        return initPage(driver, LogOutConfirmationModalBase.class);
    }
}
