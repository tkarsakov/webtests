package com.solvd.onlinertests.common;

import com.solvd.onlinertests.components.CompareComponent;
import com.solvd.onlinertests.components.MainNavigationBarComponent;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class OnlinerPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"b-top-menu\"]")
    private MainNavigationBarComponent mainNavBarComponent;

    public OnlinerPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public MainNavigationBarComponent getMainNavBarComponent() {
        return mainNavBarComponent;
    }

}
