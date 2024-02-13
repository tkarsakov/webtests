package com.solvd.onlinertests;

import com.solvd.onlinertests.common.MainBarCategory;
import com.solvd.onlinertests.pages.CatalogPage;
import com.solvd.onlinertests.pages.CategoryPage;
import com.solvd.onlinertests.pages.ComparisonPage;
import com.solvd.onlinertests.pages.ProductPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class OnlinerCompareTest implements IAbstractTest {

    @Test
    public void testAddTwoItemsToCompare(){
        List<String> productsOnPages = new ArrayList<>();
        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.open();
        CategoryPage categoryPage = catalogPage.clickMainBarCategory(MainBarCategory.LAPTOPS);

        ProductPage productPage = categoryPage.clickOnProductByOrder(1);
        productsOnPages.add(productPage.getProductName());
        productPage.clickOnAddToComparsionCheckbox();

        getDriver().navigate().back();

        productPage = categoryPage.clickOnProductByOrder(2);
        productsOnPages.add(productPage.getProductName());
        productPage.clickOnAddToComparsionCheckbox();

        ComparisonPage comparisonPage = productPage.clickCompareButton();
        List<String> productsInComparison = comparisonPage.getProductsInComparison();
        Integer numberOfProductsInComparison = comparisonPage.getAmountOfProductsInComparsion();
        Assert.assertEquals(productsInComparison, productsOnPages);
        Assert.assertEquals(2, numberOfProductsInComparison);
    }
}
