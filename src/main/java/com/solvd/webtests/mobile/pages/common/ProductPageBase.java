package com.solvd.webtests.mobile.pages.common;

import com.solvd.webtests.mobile.entity.Item;
import com.solvd.webtests.mobile.modal.android.CartModal;
import com.solvd.webtests.mobile.modal.android.SideMenuModal;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {
    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Item getItem();

    public abstract ProductPageBase clickAddToCartButton();

    public abstract SideMenuModal getSideMenuModal();

    public abstract CartModal getCartModal();
}
