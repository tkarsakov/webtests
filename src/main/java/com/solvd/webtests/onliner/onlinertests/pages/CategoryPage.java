package com.solvd.onlinertests.pages;

import com.solvd.onlinertests.common.OnlinerPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends OnlinerPage {

    private final String categoryPrefix;

    @FindBy(xpath = "(//div[@class=\"catalog-form__offers-item catalog-form__offers-item_primary\"])[1]")
    private ExtendedWebElement productBlock;

    @FindBy(xpath = "(//a[contains(text(), \"%s\")])[%d]")
    private ExtendedWebElement productByOrder;

    public CategoryPage(WebDriver driver, String categoryPrefix) {
        super(driver);
        this.categoryPrefix = categoryPrefix;
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productBlock);
    }

    public ProductPage clickOnProductByOrder(Integer order) {
        ExtendedWebElement product = productByOrder.format(categoryPrefix, order);
        product.click();
        product.clickIfPresent(3);
        return new ProductPage(driver);
    }
}
