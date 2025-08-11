package com.booleanuk.core;

public abstract class Item {

    protected String SKU;
    protected int price;
    protected String name;
    protected String variant;

    public Item(String SKU, int price, String name, String variant) {
        this.SKU = SKU;
        this.price = price;
        this.name = name;
        this.variant = variant;
    }

    public String getVariant() {
        return variant;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getSKU() {
        return SKU;
    }
}
