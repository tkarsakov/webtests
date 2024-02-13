package com.solvd.webtests.web.components;

import com.solvd.webtests.web.pages.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartButtonComponent extends AbstractUIObject {

    @FindBy(id = "cart_link")
    private ExtendedWebElement cartButton;

    public CartButtonComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }
}
