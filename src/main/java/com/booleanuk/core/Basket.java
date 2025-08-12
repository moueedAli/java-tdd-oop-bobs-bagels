package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private int capacity;
    private List<Item> customerBasket;

    public Basket(int capacity) {
        this.capacity = capacity;
        this.customerBasket = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int newCapacity) {
        ;
    }

    public boolean isFull() {
        return false;
    }

    public int getRemainingCapacity() {
        return 0;
    }

    public boolean addItem(Item item, Inventory inventory) {
        return false;
    }

    public boolean removeItem(Item item) {
        return false;
    }

    public double calculateTotalCost() {
        return 0.0;
    }

    public boolean containsItem(Item item) {
        return false;
    }

    public void clearBasket() {
        customerBasket.clear();
    }
}
