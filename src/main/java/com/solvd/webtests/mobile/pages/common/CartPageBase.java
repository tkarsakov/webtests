package com.solvd.webtests.mobile.pages.common;

import com.solvd.webtests.mobile.entity.Item;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

public abstract class CartPageBase extends AbstractPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Item getItemByRow(Integer row);

    public abstract BigDecimal getTotalPrice();

    public abstract CartPageBase clickRemoveItemByRow(Integer row);

    public abstract Boolean isCartEmpty();
}
