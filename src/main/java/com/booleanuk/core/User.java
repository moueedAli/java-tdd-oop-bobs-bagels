package com.booleanuk.core;

public abstract class User {
    protected String name;
    protected Basket basket;
    protected int DEFAULT_CAPACITY = 5;

    public User(String name) {
        this.name = name;
        this.basket = new Basket(DEFAULT_CAPACITY);
    }

    public String getName() {
        return name;
    }

    public Basket getBasket() {
        return basket;
    }

    public boolean addItemToBasket(Item item, Inventory inventory) {
        return true;
    }

    public boolean removeItemFromBasket(Item item) {
        return true;
    }

    public boolean isBasketFull() {
        return true;
    }
}
