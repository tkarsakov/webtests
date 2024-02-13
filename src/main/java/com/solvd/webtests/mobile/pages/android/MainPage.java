package com.solvd.webtests.mobile.pages.android;

import com.solvd.webtests.mobile.components.android.CartModal;
import com.solvd.webtests.mobile.pages.common.MainPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @FindBy
    private CartModal cartModal;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartModal getCartModal() {
        return cartModal;
    }
}
