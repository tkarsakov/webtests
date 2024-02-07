package com.solvd.webtests.web.pages;

import com.solvd.webtests.web.pages.common.SteamStorePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class StorePage extends SteamStorePageBase {

    @FindBy(id = "tab_%s_content_trigger")
    private ExtendedWebElement contentTab;

    public StorePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }

    public StorePage switchContentTab(ContentTab tab) {
        contentTab.format(tab.name()).click();
        return this;
    }
}
