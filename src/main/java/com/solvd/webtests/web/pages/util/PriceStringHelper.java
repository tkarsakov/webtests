package com.solvd.webtests.web.pages.util;

import java.math.BigDecimal;

public class PriceStringHelper {
    public static BigDecimal priceStringToBigDecimal(String priceString, PriceStringType type, Currency currency) {
        BigDecimal price = null;
        switch (type) {
            case PRICE:
                price = new BigDecimal(priceString.replace("$", ""));
                break;
            case TOTAL:
                price = new BigDecimal(priceString.replace("$", "").replace(currency.getCurrencyString(), ""));
                break;
        }
        return price;
    }

    public static BigDecimal priceStringToBigDecimal(String priceString, PriceStringType type) {
        BigDecimal price = null;
        switch (type) {
            case PRICE:
                price = new BigDecimal(priceString.replace("$", ""));
                break;
            case TOTAL:
                price = new BigDecimal(priceString.replace("$", "").replace(Currency.USD.getCurrencyString(), ""));
                break;
        }
        return price;
    }
}
