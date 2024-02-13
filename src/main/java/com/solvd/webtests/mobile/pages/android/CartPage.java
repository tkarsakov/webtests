package com.solvd.webtests.mobile.pages.android;

import com.solvd.webtests.mobile.modal.android.CartModal;
import com.solvd.webtests.mobile.modal.android.SideMenuModal;
import com.solvd.webtests.mobile.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy
    private SideMenuModal sideMenuModal;

    @FindBy
    private CartModal cartModal;

    @ExtendedFindBy(accessibilityId = "Go Shopping button")
    private ExtendedWebElement goShoppingButton;

    @ExtendedFindBy(accessibilityId = "Proceed To Checkout button")
    private ExtendedWebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return goShoppingButton.isElementPresent() || proceedToCheckoutButton.isElementPresent();
    }
}
