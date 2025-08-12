package com.booleanuk.core;

public class Manager extends User {

    private String name;
    private Inventory inventory;
    private Basket basket;

    public Manager(String name) {
        super(name);
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public boolean isInInventory(Item item) {
        return true;
    }

    public boolean addToInventory(Item item) {
        return true;
    }

    public boolean removeFromInventory(Item item) {
        return true;
    }

    public void changeCapacityOfBaskets(int newCap) {
        ;
    }
}
