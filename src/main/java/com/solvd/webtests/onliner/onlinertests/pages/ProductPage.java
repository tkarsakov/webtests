package com.solvd.onlinertests.pages;

import com.solvd.onlinertests.common.OnlinerPage;
import com.solvd.onlinertests.components.CompareComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends OnlinerPage {

    @FindBy(xpath = "//h1[contains(@class, \"catalog-masthead__title js-nav-header\")]")
    private ExtendedWebElement productNameHeader;

    @FindBy(xpath = "//li[@id=\"product-compare-control\"]//span[@class=\"i-checkbox__faux\"]")
    private ExtendedWebElement addToComparsionCheckbox;

    @FindBy(xpath = "//li[@id=\"product-compare-control\"]//span[@class=\"i-checkbox__faux\"]/following::span[contains(text(), \"к сравнению\")]")
    private ExtendedWebElement addToComparsionText;

    @FindBy(xpath = "(//div[@class=\"compare-button__state compare-button__state_initial\"])[1]")
    private CompareComponent compareComponent;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public ProductPage clickOnAddToComparsionCheckbox() {
        addToComparsionCheckbox.click();
        return this;
    }

    public Boolean isProductAddedToComparsion() {
        return addToComparsionText.getText().contains("Добавлен");
    }

    public String getProductName() {
        return productNameHeader.getText();
    }

    public ComparisonPage clickCompareButton() {
        compareComponent.clickOnComparisonButton();
        return new ComparisonPage(driver);
    }
}
