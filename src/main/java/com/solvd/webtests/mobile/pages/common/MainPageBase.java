package com.solvd.webtests.mobile.pages.common;

import com.solvd.webtests.mobile.components.android.CartModal;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainPageBase extends AbstractPage {

    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartModal getCartModal();
}
