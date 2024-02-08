package com.solvd.webtests.web.pages;

import com.solvd.webtests.web.pages.common.SteamStorePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class StorePage extends SteamStorePageBase {

    @FindBy(id = "tab_%s_content_trigger")
    private ExtendedWebElement contentTab;

    @FindBy(xpath = "//div[@style='display: block;']//a[contains(@class, 'tab_item')]//div[@class='discount_final_price' and contains(text(), '$')]")
    private List<ExtendedWebElement> paidGamesInTab;

    public StorePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public void switchContentTab(ContentTab tab) {
        contentTab.format(tab.name()).click();
    }

    public ProductPage clickOnProductWithPrice(ExtendedWebElement product) {
        product.click();
        return new ProductPage(driver);
    }
}
