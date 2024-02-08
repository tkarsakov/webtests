package com.solvd.webtests.web.pages;

import com.solvd.webtests.web.pages.common.SteamStorePageBase;
import com.solvd.webtests.web.pages.util.PriceStringType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

import static com.solvd.webtests.web.pages.util.PriceStringHelper.priceStringToBigDecimal;

public class ProductPage extends SteamStorePageBase {

    @FindBy(id = "appHubAppName")
    private ExtendedWebElement productName;

    @FindBy(className = "game_purchase_price price")
    private ExtendedWebElement priceDiv;

    @FindBy(xpath = "//h1[.='Buy %s']//following::div//a[contains(@id, 'btn_add_to_cart')]")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickAddToCartButton() {
        addToCartButton.format(productName.getText()).click();
        return new CartPage(driver);
    }

    public BigDecimal getProductPrice() {
        return priceStringToBigDecimal(priceDiv.getText(), PriceStringType.PRICE);
    }
}
