package com.booleanuk.core;

import java.util.List;

public class Customer extends User{

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

    public double viewCostBeforeAdding(Item item) {
        return item.getPrice();
    }
}


