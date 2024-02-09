package com.solvd.webtests.web.pages;

import com.solvd.webtests.web.entity.ExpectedSearchResult;
import com.solvd.webtests.web.pages.common.SteamStorePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends SteamStorePageBase {

    @FindBy(xpath = "//a[contains(@class,'search_result_row')][%d]//span[.='%s']")
    private ExtendedWebElement searchResultByOrderAndName;

    @FindBy(xpath = "//span[.='%s']")
    private ExtendedWebElement searchResultNameSpan;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isExpectedResultCorrect(ExpectedSearchResult expectedSearchResult) {
        for (var entry : expectedSearchResult.getSearchResults().entrySet()) {
            if (!searchResultByOrderAndName.format(entry.getValue(), entry.getKey()).isPresent()) {
                return false;
            }
        }
        return true;
    }
}
