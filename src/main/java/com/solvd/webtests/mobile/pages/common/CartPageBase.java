package com.solvd.webtests.mobile.pages.common;

import com.solvd.webtests.mobile.entity.Item;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends AbstractPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Item getItemByRow(Integer row);
}
