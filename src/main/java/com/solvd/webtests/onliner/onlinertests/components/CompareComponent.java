package com.solvd.onlinertests.components;

import com.solvd.onlinertests.pages.ComparisonPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CompareComponent extends AbstractUIObject {

    @FindBy(xpath = "(//a[@title=\"Очистить список сравнения\"]/following::a)[1]")
    private ExtendedWebElement comparisonButton;

    public CompareComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ComparisonPage clickOnComparisonButton() {
        comparisonButton.clickIfPresent(4);
        return new ComparisonPage(driver);
    }
}
