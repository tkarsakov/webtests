package com.solvd.webtests.web.components;

import com.solvd.webtests.web.pages.ProductPage;
import com.solvd.webtests.web.pages.StorePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class StoreNavComponent extends AbstractUIObject {

    @FindBy(id = "foryou_tab")
    private ExtendedWebElement yourStoreTab;

    @FindBy(id = "store_nav_search_term")
    private ExtendedWebElement searchBar;

    public StoreNavComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public StorePage clickYourStoreNavTab() {
        yourStoreTab.click();
        return new StorePage(driver);
    }

    public ProductPage searchAndClickItemInResults(String itemName) {
        searchBar.type(itemName);
        String xpath = String.format("//a[contains(@class, 'match_app')]/div[.='%s']", itemName);
        searchBar.findElement(By.xpath(xpath)).click();
        return new ProductPage(driver);
    }
}