package com.solvd.webtests.mobile.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public abstract class LogInPageBase extends AbstractPage {
    public LogInPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LogInPageBase typeUsername(String username);

    public abstract LogInPageBase typePass(String pass);

    public abstract Optional<MainPageBase> clickLogInButton();
}
