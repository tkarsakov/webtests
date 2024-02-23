package com.solvd.onlinertests.components;

import com.solvd.onlinertests.pages.CatalogPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainNavigationBarComponent extends AbstractUIObject {

    @FindBy(xpath = "//ul[@class=\"b-main-navigation\"]//span[.=\"Каталог\"]")
    private ExtendedWebElement catalogButton;

    public MainNavigationBarComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CatalogPage clickCatalogNavButton() {
        catalogButton.click();
        return new CatalogPage(driver);
    }
}
