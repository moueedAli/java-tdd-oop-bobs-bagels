package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Bagel extends Item{

    private List<Fillings> fillings;
    Inventory inventory = new Inventory();

    public Bagel(String SKU, double price, String name, String variant) {
        super(SKU, price, name, variant);
        this.fillings = new ArrayList<>();
    }

    public void addFillings(Fillings filling) {
        ;
    }

    public boolean removeFillings(Fillings filling) {
        return true;
    }

    public List<Fillings> getFillings() {
        return fillings;
    }

    public double getBagelPrice() {
        return 0.0;
    }
}
