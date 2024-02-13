package com.solvd.webtests.mobile.pages.android;

import com.solvd.webtests.mobile.pages.common.LogInPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {
    public LogInPage(WebDriver driver) {
        super(driver);
    }
}
