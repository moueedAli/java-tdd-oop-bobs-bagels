package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private int MAX_CAPACITY = 10;
    private List<Item> customerBasket;

    public Basket() {
        this.customerBasket = new ArrayList<>();
    }

    public int getCapacity() {
        return MAX_CAPACITY;
    }

    public void setCapacity(int newCapacity) {
        this.MAX_CAPACITY = newCapacity;
    }

    public boolean isFull() {
        return this.MAX_CAPACITY == customerBasket.size();
    }

    public int getRemainingCapacity() {
        return MAX_CAPACITY - customerBasket.size();
    }

    public boolean addItem(Item item, Inventory inventory) {
        if (isFull() || !inventory.isInInventory(item.SKU)) {
            return false;
        }
        else {
            customerBasket.add(item);
        }
        return true;
    }

    public boolean removeItem(Item item) {
        if (customerBasket.isEmpty() || !customerBasket.contains(item)) {
            return false;
        }
        else {
            customerBasket.remove(item);
            return true;
        }
    }

    public double calculateTotalCost() {
        double totalcost = 0;

        for (Item i : customerBasket) {
            totalcost += i.price;
        }

        return totalcost;
    }

    public boolean containsItem(Item item) {
        return customerBasket.contains(item);
    }

    public void clearBasket() {
        customerBasket.clear();
    }
}
