package com.solvd.webtests.web.service;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollingService {
    public static void scrollDown(Long pixels, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long pageOffset = (Long) js.executeScript("return window.pageYOffset;");
        js.executeScript("window.scrollBy(arguments[0], arguments[1])", pageOffset, pixels);
    }

    public static Long getScrollingPosition(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return Math.round((Double) js.executeScript("return window.pageYOffset;"));
    }
}
