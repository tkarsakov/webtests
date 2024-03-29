package com.solvd.webtests.web.components;

import com.solvd.webtests.web.pages.ProductPage;
import com.solvd.webtests.web.pages.SearchResultPage;
import com.solvd.webtests.web.pages.StorePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class StoreNavComponent extends AbstractUIObject {

    @FindBy(id = "foryou_tab")
    private ExtendedWebElement yourStoreTab;

    @FindBy(id = "store_nav_search_term")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//a[contains(@class, 'match_app')]/div[text()='%s']")
    private ExtendedWebElement searchResultGame;

    @FindBy(xpath = "//a[@id='store_search_link']/img")
    private ExtendedWebElement searchButton;

    public StoreNavComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public StorePage clickYourStoreNavTab() {
        yourStoreTab.click();
        return new StorePage(driver);
    }

    public ProductPage clickOnItemInSearchResultsByName(String itemName) {
        searchResultGame.format(itemName).click();
        return new ProductPage(driver);
    }

    public StoreNavComponent typeSearchPhrase(String itemName) {
        searchBar.type(itemName);
        return this;
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();
        return new SearchResultPage(driver);
    }
}
