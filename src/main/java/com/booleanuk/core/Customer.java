package com.booleanuk.core;

public class Customer extends User{

    private String name;

    public Customer(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public boolean addItemToBasket(Item item, Inventory inventory) {
        return basket.addItem(item, inventory);
    }

    public boolean removeItemFromBasket(Item item) {
        return basket.removeItem(item);
    }

    public double viewTotalCost() {
        return basket.calculateTotalCost();
    }
}


