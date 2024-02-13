package com.solvd.webtests.mobile.pages.android;

import com.solvd.webtests.mobile.modal.android.CartModal;
import com.solvd.webtests.mobile.modal.android.SideMenuModal;
import com.solvd.webtests.mobile.pages.common.LogInPageBase;
import com.solvd.webtests.mobile.pages.common.MainPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Optional;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LogInPageBase.class)
public class LogInPage extends LogInPageBase {

    @ExtendedFindBy(accessibilityId = "Username input field")
    private ExtendedWebElement usernameField;

    @ExtendedFindBy(accessibilityId = "Password input field")
    private ExtendedWebElement passField;

    @ExtendedFindBy(accessibilityId = "Login button")
    private ExtendedWebElement loginButton;

    @ExtendedFindBy(accessibilityId = "generic-error-message")
    private ExtendedWebElement errorMessage;

    @FindBy
    private SideMenuModal sideMenuModal;

    @FindBy
    private CartModal cartModal;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LogInPageBase typeUsername(String username) {
        usernameField.type(username);
        return this;
    }

    @Override
    public LogInPageBase typePass(String pass) {
        passField.type(pass);
        return this;
    }

    @Override
    public Optional<MainPageBase> clickLogInButton() {
        loginButton.click();
        if (errorMessage.isDisplayed()) {
            return Optional.empty();
        } else {
            return Optional.of(initPage(driver, MainPageBase.class));
        }
    }
}
