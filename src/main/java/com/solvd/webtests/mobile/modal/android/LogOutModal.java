package com.solvd.webtests.mobile.modal.android;

import com.solvd.webtests.mobile.modal.common.LogOutConfirmationModalBase;
import com.solvd.webtests.mobile.modal.common.LogOutModalBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogOutModalBase.class)
public class LogOutModal extends LogOutModalBase {

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement logOutButton;

    @FindBy(id = "android:id/button2")
    private ExtendedWebElement cancelButton;

    public LogOutModal(WebDriver driver) {
        super(driver);
    }

    public LogOutModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LogOutConfirmationModalBase clickLogOut() {
        logOutButton.click();
        return initPage(driver, LogOutConfirmationModalBase.class);
    }
}
