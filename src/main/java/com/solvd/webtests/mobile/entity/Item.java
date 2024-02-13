package com.solvd.webtests.mobile.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {

    private final String itemName;
    private final BigDecimal itemPrice;

    public Item(String itemName, BigDecimal itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemName, item.itemName) && Objects.equals(itemPrice, item.itemPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemPrice);
    }
}
