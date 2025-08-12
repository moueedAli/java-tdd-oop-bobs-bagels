package com.booleanuk.core;

public abstract class User {
    protected String name;
    protected Basket basket = new Basket();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Basket getBasket() {
        return basket;
    }

    public boolean addItemToBasket(Item item, Inventory inventory) {
        return basket.addItem(item, inventory);
    }

    public boolean removeItemFromBasket(Item item) {
        return basket.removeItem(item);
    }

    public boolean isBasketFull() {
        return basket.isFull();
    }
}
