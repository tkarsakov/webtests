package com.solvd.webtests.web.pages;

import com.solvd.webtests.web.pages.common.SteamStorePageBase;
import com.solvd.webtests.web.pages.util.PriceStringType;
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

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
    }

    public BigDecimal getItemPrice(ExtendedWebElement cartItem) {
        return priceStringToBigDecimal(cartItem.findElement(By.xpath("//div[@class='price']")).getText(), PriceStringType.PRICE);
    }

    public void removeItemFromCart(ExtendedWebElement cartItem) {
        cartItem.findElement(By.xpath("//a[@class='remove_link']")).click();
    }

    public BigDecimal getEstimatedTotal() {
        return priceStringToBigDecimal(estimatedTotal.getText(), PriceStringType.TOTAL);
    }

    public List<String> getItemNames() {
        List<String> names = new ArrayList<>();
        for (var element : cartItems) {
            names.add(element.findElement(By.xpath("./div[@class='cart_item_desc']/a")).getText());
        }
        return names;
    }
}
