package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Item{

    private List<Fillings> fillings = new ArrayList<>();

    public Bagel(String SKU, double price, String name, String variant) {
        super(SKU, price, name, variant);
    }

    public void addFillings(Fillings filling) {
        fillings.add(filling);
    }

    public boolean removeFillings(Fillings filling, Inventory inventory) {
        if(fillings.isEmpty() || !fillings.contains(filling) || !inventory.isInInventory(filling.getSKU())) {
            return false;
        }
        else {
            fillings.remove(filling);
            return true;
        }
    }

    public List<Fillings> getFillings() {
        return fillings;
    }

    public double getBagelPrice() {
        double totPrice = 0;
        for (Fillings f: fillings) {
            totPrice += f.getPrice();
        }

        totPrice += this.getPrice();
        return totPrice;
    }
}
