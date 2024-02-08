package com.solvd.webtests.web.pages.common;

public enum Locale {
    RU("ru", "ru_RU"),
    EN("en", "en_US");

    private final String locale;

    private final String lang;

    Locale(String lang, String locale) {
        this.locale = locale;
        this.lang = lang;
    }

    public String getLocale() {
        return locale;
    }

    public String getLang() {
        return lang;
    }
}
