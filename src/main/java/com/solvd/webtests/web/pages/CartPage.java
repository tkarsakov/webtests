package com.solvd.webtests.web.pages;

import com.solvd.webtests.web.pages.common.SteamStorePageBase;
import com.solvd.webtests.web.pages.util.Currency;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.webtests.web.pages.util.PriceStringHelper.priceStringToBigDecimal;

public class CartPage extends SteamStorePageBase {

    @FindBy(className = "cart_item")
    private List<ExtendedWebElement> cartItems;

    @FindBy(id = "cart_estimated_total")
    private ExtendedWebElement estimatedTotal;

    @FindBy(xpath = "//div[@class='cart_item_desc'][contains(.,'%s')]/preceding-sibling::div[@class='cart_item_price_container']/div/a")
    private ExtendedWebElement removeFromCartLink;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
    }

    public BigDecimal getItemPrice(ExtendedWebElement cartItem) {
        return priceStringToBigDecimal(cartItem.findElement(By.xpath("//div[@class='price']")).getText(), Currency.USD);
    }

    public CartPage removeItemFromCartByName(String itemName) {
        removeFromCartLink.format(itemName).click();
        return this;
    }

    public BigDecimal getEstimatedTotal() {
        return priceStringToBigDecimal(estimatedTotal.getText(), Currency.USD);
    }

    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        for (var element : cartItems) {
            names.add(element.findElement(By.xpath("./div[@class='cart_item_desc']/a")).getText());
        }
        return names;
    }
}
