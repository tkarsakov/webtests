package com.solvd.webtests.web.pages;

import com.solvd.webtests.web.components.CartButtonComponent;
import com.solvd.webtests.web.components.StoreNavComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class StorePage extends AbstractPage {

    @FindBy(xpath = "//div[@class='store_nav']")
    private StoreNavComponent storeNavComponent;

    @FindBy(id = "tab_%s_content_trigger")
    private ExtendedWebElement contentTab;

    @FindBy(id = "store_header_cart_btn")
    private CartButtonComponent cartButtonComponent;

    private enum Tabs {
        newreleases,
        topsellers,
        upcoming
    }

    public StorePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }
}
