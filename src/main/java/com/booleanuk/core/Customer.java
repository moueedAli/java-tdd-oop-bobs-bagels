package com.booleanuk.core;

public class Customer extends User{

    private String name;
    private Basket basket;

    public Customer(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public boolean addItemToBasket(Item item, Inventory inventory) {
        return true;
    }

    public boolean removeItemFromBasket(Item item) {
        return true;
    }

    public double viewTotalCost() {
        return 0.0;
    }
}


