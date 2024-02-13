package com.solvd.webtests.mobile.components.android;

import com.solvd.webtests.mobile.components.common.CartModalBase;
import com.solvd.webtests.mobile.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartModal.class)
public class CartModal extends CartModalBase {

    @ExtendedFindBy(accessibilityId = "cart badge")
    private ExtendedWebElement cartButton;

    public CartModal(WebDriver driver) {
        super(driver);
    }

    public CartModal(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    @Override
    public CartPageBase clickCartButton() {
        cartButton.click();
        return initPage(driver, CartPageBase.class);
    }

}
