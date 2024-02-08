package com.solvd.webtests.web.pages.common;

import com.solvd.webtests.web.components.CartButtonComponent;
import com.solvd.webtests.web.components.StoreNavComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class SteamStorePageBase extends AbstractPage {

    @FindBy(tagName = "html")
    public ExtendedWebElement htmlTag;

    @FindBy(xpath = "//div[@class='store_nav']")
    protected StoreNavComponent storeNavComponent;

    @FindBy(id = "store_header_cart_btn")
    protected CartButtonComponent cartButtonComponent;

    public SteamStorePageBase(WebDriver driver) {
        super(driver);
    }

    public StoreNavComponent getStoreNavComponent() {
        return storeNavComponent;
    }

    public CartButtonComponent getCartButtonComponent() {
        return cartButtonComponent;
    }

    public Locale getLocale() {
        return Locale.valueOf(htmlTag.getAttribute("lang").toUpperCase());
    }
}
