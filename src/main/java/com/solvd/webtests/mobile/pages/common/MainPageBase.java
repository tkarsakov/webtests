package com.solvd.webtests.mobile.pages.common;

import com.solvd.webtests.mobile.entity.Item;
import com.solvd.webtests.mobile.modal.android.CartModal;
import com.solvd.webtests.mobile.modal.android.SideMenuModal;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainPageBase extends AbstractPage {

    public MainPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartModal getCartModal();

    public abstract SideMenuModal getSideMenuModal();

    public abstract Item getStoreItemByOrder(Integer order);

    public abstract ProductPageBase clickOnStoreItemByOrder(Integer order);
}
