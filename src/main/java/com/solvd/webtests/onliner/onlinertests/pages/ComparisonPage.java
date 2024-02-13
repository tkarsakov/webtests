package com.solvd.onlinertests.pages;

import com.solvd.onlinertests.common.OnlinerPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ComparisonPage extends OnlinerPage {

    private static final Integer NON_PRODUCT_COLUMNS_AMOUNT = 2;
    @FindBy(xpath = "//table//tr[contains(@class, \"product-table__row_header product-table__row_top\")]//th")
    private List<ExtendedWebElement> productColumns;

    @FindBy(xpath = "//table//tr[contains(@class, \"product-table__row_header product-table__row_top\")]//th//span[@class=\"product-summary__caption\"]")
    private List<ExtendedWebElement> productNames;

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    public Integer getAmountOfProductsInComparsion() {
        return productColumns.size() - NON_PRODUCT_COLUMNS_AMOUNT;
    }

    public List<String> getProductsInComparison() {
        return productNames.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }
}
