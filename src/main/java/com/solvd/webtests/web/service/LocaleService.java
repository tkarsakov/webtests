package com.solvd.webtests.web.service;

import com.solvd.webtests.web.pages.common.Locale;
import com.zebrunner.carina.utils.R;

public class LocaleService {
    public static void setLocaleInConfig(Locale locale) {
        switch (locale) {
            case DE:
            case RU:
            case EN:
                R.CONFIG.put("locale", locale.getLocale(), true);
                break;
            default:
                throw new RuntimeException("Locale not found!");
        }
    }

    public static void setBrowserLocaleInConfig(Locale locale) {
        switch (locale) {
            case DE:
            case RU:
            case EN:
                R.CONFIG.put("browser_language", locale.getLocale(), true);
                break;
            default:
                throw new RuntimeException("Locale not found!");
        }
    }

    public static void setBothLocaleAndBrowserLocaleInConfig(Locale locale) {
        setLocaleInConfig(locale);
        setBrowserLocaleInConfig(locale);
    }
}
