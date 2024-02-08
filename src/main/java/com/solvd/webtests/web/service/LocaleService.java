package com.solvd.webtests.web.service;

import com.solvd.webtests.web.pages.common.Locale;
import com.zebrunner.carina.utils.R;

public class LocaleService {
    public static void setLocaleInConfig(Locale locale) {
        switch (locale) {
            case RU:
            case EN:
                R.CONFIG.put("locale", locale.getLocale());
                break;
            default:
                throw new RuntimeException("Locale not found!");
        }
    }
}
