package com.solvd.webtests.mobile.pages.android;

import com.solvd.webtests.mobile.entity.Item;
import com.solvd.webtests.mobile.entity.ItemFields;
import com.solvd.webtests.mobile.modal.android.CartModal;
import com.solvd.webtests.mobile.modal.android.SideMenuModal;
import com.solvd.webtests.mobile.pages.common.MainPageBase;
import com.solvd.webtests.mobile.pages.common.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainPageBase.class)
public class MainPage extends MainPageBase {

    @FindBy
    private SideMenuModal sideMenuModal;

    @FindBy
    private CartModal cartModal;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"store item\"])[%d]//android.widget.TextView[@content-desc=\"store item %s\"]")
    private ExtendedWebElement storeItemText;

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"store item\"])[%d]/android.view.ViewGroup[1]")
    private ExtendedWebElement storeItem;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartModal getCartModal() {
        return cartModal;
    }

    @Override
    public SideMenuModal getSideMenuModal() {
        return sideMenuModal;
    }

    @Override
    public Item getStoreItemByOrder(Integer order) {
        String itemName = storeItemText.format(order, ItemFields.text.name()).getAttribute("text");
        BigDecimal itemPrice = new BigDecimal(storeItemText.format(order, ItemFields.price.name()).getAttribute("text").replace("$", ""));
        return new Item(itemName, itemPrice);
    }

    @Override
    public ProductPageBase clickOnProductByOrder(Integer order) {
        storeItem.click();
        return initPage(driver, ProductPageBase.class);
    }
}
