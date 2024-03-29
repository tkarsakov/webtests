package com.solvd.webtests.mobile.pages.android;

import com.solvd.webtests.mobile.entity.Item;
import com.solvd.webtests.mobile.modal.android.CartModal;
import com.solvd.webtests.mobile.modal.android.SideMenuModal;
import com.solvd.webtests.mobile.modal.common.CartProductField;
import com.solvd.webtests.mobile.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy
    private SideMenuModal sideMenuModal;

    @FindBy
    private CartModal cartModal;

    @ExtendedFindBy(accessibilityId = "total price")
    private ExtendedWebElement totalPrice;

    @FindBy(xpath = "(//android.widget.TextView[@text=\"Remove Item\"])[%d]")
    private ExtendedWebElement removeItemButtonByRow;

    @ExtendedFindBy(accessibilityId = "Go Shopping button")
    private ExtendedWebElement goShoppingButton;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"product row\"])[%d]/android.widget.TextView[@content-desc=\"product %s\"]")
    private ExtendedWebElement itemTextByRowAndField;

    @ExtendedFindBy(accessibilityId = "Proceed To Checkout button")
    private ExtendedWebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return goShoppingButton.isElementPresent() || proceedToCheckoutButton.isElementPresent();
    }

    @Override
    public Item getItemByRow(Integer row) {
        String itemName = itemTextByRowAndField.format(row, CartProductField.LABEL.name().toLowerCase()).getAttribute("text");
        BigDecimal itemPrice = new BigDecimal(itemTextByRowAndField.format(row, CartProductField.PRICE.name().toLowerCase()).getAttribute("text").replace("$", ""));
        return new Item(itemName, itemPrice);
    }

    @Override
    public BigDecimal getTotalPrice() {
        return new BigDecimal(totalPrice.getAttribute("text").replace("$", ""));
    }

    @Override
    public CartPageBase clickRemoveItemByRow(Integer row) {
        removeItemButtonByRow.format(row).click();
        return this;
    }

    @Override
    public Boolean isCartEmpty() {
        return goShoppingButton.isElementPresent();
    }
}
