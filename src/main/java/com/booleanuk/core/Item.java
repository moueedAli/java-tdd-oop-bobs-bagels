package com.booleanuk.core;

public class Item {

    protected String SKU;
    protected double price;
    protected String name;
    protected String variant;

    public Item(String SKU, double price, String name, String variant) {
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

    public double getPrice() {
        return price;
    }

    public String getSKU() {
        return SKU;
    }
}
