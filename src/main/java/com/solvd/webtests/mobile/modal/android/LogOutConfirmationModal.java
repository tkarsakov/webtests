package com.solvd.webtests.mobile.modal.android;

import com.solvd.webtests.mobile.modal.common.LogOutConfirmationModalBase;
import com.solvd.webtests.mobile.pages.common.LogInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogOutConfirmationModalBase.class)
public class LogOutConfirmationModal extends LogOutConfirmationModalBase {

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement okButton;

    public LogOutConfirmationModal(WebDriver driver) {
        super(driver);
    }

    public LogOutConfirmationModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LogInPageBase clickOk() {
        okButton.click();
        return initPage(driver, LogInPageBase.class);
    }
}
