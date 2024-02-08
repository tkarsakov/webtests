package com.solvd.webtests.web.pages.util;

import java.math.BigDecimal;

public class PriceStringHelper {
    public static BigDecimal priceStringToBigDecimal(String priceString, Currency currency) {
        BigDecimal price = null;
        price = new BigDecimal(priceString.replace("$", "").replace(currency.getCurrencyString(), ""));
        return price;
    }
}
