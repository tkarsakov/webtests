package com.solvd.webtests.mobile.components.android;

import com.solvd.webtests.mobile.components.common.SideMenuModalBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SideMenuModalBase.class)
public class SideMenuModal extends SideMenuModalBase {

    public SideMenuModal(WebDriver driver) {
        super(driver);
    }

    public SideMenuModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
