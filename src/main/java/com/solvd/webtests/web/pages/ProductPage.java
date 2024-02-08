package com.solvd.webtests.web.pages;

import com.solvd.webtests.web.pages.common.SteamStorePageBase;
import com.solvd.webtests.web.pages.util.Currency;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

import static com.solvd.webtests.web.pages.util.PriceStringHelper.priceStringToBigDecimal;

public class ProductPage extends SteamStorePageBase {

    @FindBy(id = "appHubAppName")
    private ExtendedWebElement productName;

    @FindBy(xpath = "(//div[contains(@class,'game_purchase_price')])[1]")
    private ExtendedWebElement priceDiv;

    @FindBy(xpath = "(//a[contains(@id, 'btn_add_to_cart')])[1]")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(priceDiv);
    }

    public CartPage clickAddToCartButton() {
        addToCartButton.format(productName.getText()).click();
        return new CartPage(driver);
    }

    public BigDecimal getProductPrice() {
        return priceStringToBigDecimal(priceDiv.getText(), Currency.USD);
    }

    public String getProductNameString() {
        return productName.getText();
    }
}
