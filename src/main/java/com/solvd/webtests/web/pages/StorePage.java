package com.solvd.webtests.web.pages;

import com.solvd.webtests.web.entity.Product;
import com.solvd.webtests.web.pages.common.SteamStorePageBase;
import com.solvd.webtests.web.pages.util.Currency;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.List;

import static com.solvd.webtests.web.pages.util.PriceStringHelper.priceStringToBigDecimal;

public class StorePage extends SteamStorePageBase {

    @FindBy(id = "tab_%s_content_trigger")
    private ExtendedWebElement contentTab;

    @FindBy(xpath = "(//div[@id='tab_%s_content']//a[contains(@class, 'tab_item')]//div[@class='discount_final_price' and contains(text(), '$')])")
    private List<ExtendedWebElement> paidGamesInTab;

    @FindBy(xpath = "(//div[@id='tab_%s_content']//a[contains(@class, 'tab_item')])[%d]")
    private ExtendedWebElement paidGameInCategory;

    @FindBy(xpath = "(//div[@id='tab_%s_content']//a[contains(@class, 'tab_item')])[%d]//div[@class='tab_item_name']")
    private ExtendedWebElement paidGameInCategoryName;

    @FindBy(xpath = "(//div[@id='tab_%s_content']//a[contains(@class, 'tab_item')])[%d]//div[@class='discount_final_price' and contains(text(), '$')]")
    private ExtendedWebElement paidGameInCategoryPrice;

    public StorePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public void switchContentTab(ContentTab tab) {
        contentTab.format(tab.name()).click();
    }

    public ProductPage clickOnPaidGameInContentTab(ContentTab contentTab, Integer order) {
        paidGameInCategory.format(contentTab.name(), order).click();
        return new ProductPage(driver);
    }

    public Product getProductFromContentTab(ContentTab contentTab, Integer order) {
        String productName = paidGameInCategoryName.format(contentTab.name(), order).getText();
        BigDecimal productPrice = priceStringToBigDecimal(paidGameInCategoryPrice.format(contentTab.name(), order).getText(), Currency.USD);
        return new Product(productName, productPrice);
    }
}
