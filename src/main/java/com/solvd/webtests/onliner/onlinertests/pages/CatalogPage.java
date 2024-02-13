package com.solvd.onlinertests.pages;

import com.solvd.onlinertests.common.MainBarCategory;
import com.solvd.onlinertests.common.OnlinerPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends OnlinerPage {

    @FindBy(xpath = "//a[.=\"%s\"]")
    private ExtendedWebElement mainBarElementByName;

    public CatalogPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public CategoryPage clickMainBarCategory(MainBarCategory category) {
        mainBarElementByName.format(category.getDescription());
        return new CategoryPage(driver, category.getPrefix());
    }
}
