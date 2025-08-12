package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.System.in;

public class Inventory {

    private List<Item> inventory = new ArrayList<>(Arrays.asList(
        new Bagel("BGLO", 0.49, "Bagel", "Onion" ),
        new Bagel("BGLP", 0.39, "Bagel", "Plain"),
        new Bagel("BGLE", 0.49, "Bagel", "Everything"),
        new Bagel("BGLS", 0.49, "Bagel", "Sesame"),
        new Coffee("COFB", 0.99, "Coffee", "Black"),
        new Coffee("COFW", 1.19, "Coffee", "White"),
        new Coffee("COFC", 1.29, "Coffee", "Cappuccino"),
        new Coffee("COFL", 1.29, "Coffee", "Latte"),
        new Fillings("FILB", 0.12, "Filling", "Bacon"),
        new Fillings("FILE", 0.12, "Filling", "Egg"),
        new Fillings("FILC", 0.12, "Filling", "Cheese"),
        new Fillings("FILX", 0.12, "Filling", "Cream Cheese"),
        new Fillings("FILS", 0.12, "Filling", "Smoked salmon"),
        new Fillings("FILH", 0.12, "Filling", "Ham")
    ));

    public boolean isInInventory(String sku) {
        return false;
    }

    public Item getItem(String sku) {
        return null;
    }
}
