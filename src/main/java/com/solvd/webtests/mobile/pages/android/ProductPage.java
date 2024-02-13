package com.solvd.webtests.mobile.pages.android;

import com.solvd.webtests.mobile.entity.Item;
import com.solvd.webtests.mobile.modal.android.CartModal;
import com.solvd.webtests.mobile.modal.android.SideMenuModal;
import com.solvd.webtests.mobile.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @ExtendedFindBy(accessibilityId = "product price")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView")
    private ExtendedWebElement itemName;

    @FindBy
    private SideMenuModal sideMenuModal;

    @FindBy
    private CartModal cartModal;

    @ExtendedFindBy(accessibilityId = "Add To Cart button")
    private ExtendedWebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Item getItem() {
        String itemDesc = itemName.getAttribute("text");
        BigDecimal itemPrc = new BigDecimal(itemPrice.getAttribute("text").replace("$", ""));
        return new Item(itemDesc, itemPrc);
    }

    @Override
    public ProductPageBase clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }
}
