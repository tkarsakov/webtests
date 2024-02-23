package com.solvd.onlinertests.common;

public enum MainBarCategory {
    LAPTOPS("Ноутбуки", "Ноутбук"),
    TVS("Телевизоры", "Телевизор"),
    GRAPHICS_CARDS("Видеокарты", "Видеокарта"),
    ROBOT_VACCUMS("Роботы-пылесосы", "Робот-пылесос");

    private final String description;
    private final String prefix;

    MainBarCategory(String description, String prefix) {
        this.description = description;
        this.prefix = prefix;
    }

    public String getDescription() {
        return description;
    }

    public String getPrefix() {
        return prefix;
    }
}
