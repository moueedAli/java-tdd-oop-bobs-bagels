package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private static int MAX_CAPACITY = 2;
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
        if (isFull() || !inventory.isInInventory(item.SKU) || isFull()) {
            return false;
        }
        else
            customerBasket.add(item);

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

    public double calculateDiscount() {
        List<Item> bagels = new ArrayList<>();
        int rest;
        int quantDisc;

        for (Item i: customerBasket) {
            if (i.name.equals("Bagel")) {
                bagels.add(i);
            }
        }

        if (bagels.size() < 5) {
            return calculateTotalCost();
        }
        else if (bagels.size() >= 6 && bagels.size() < 12) {
            rest = bagels.size() % 6;
            double totalCost = 2.49;

            for (int i = bagels.size()-1; i > 5; i--) {
                totalCost += bagels.get(i).getPrice();
            }

            return totalCost;
        }
        else {
            quantDisc = bagels.size() / 12;
            rest = bagels.size() % 12;
            double totalCost = 0;

            if (quantDisc >= 1) {
                totalCost += quantDisc*3.99;
            }

            for (int i = bagels.size()-1; i > 11; i--) {
                totalCost += bagels.get(i).getPrice();
            }

            return totalCost;
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
