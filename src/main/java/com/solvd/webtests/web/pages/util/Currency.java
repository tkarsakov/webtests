package com.solvd.webtests.web.pages.util;

public enum Currency {
    USD(" USD"),
    RUB(" RUB"),
    PLN(" PLN");

    private final String currencyString;

    Currency(String currencyString) {
        this.currencyString = currencyString;
    }


    public String getCurrencyString() {
        return this.currencyString;
    }
}
