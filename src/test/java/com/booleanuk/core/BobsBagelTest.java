package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BobsBagelTest {

    @Test
    public void testChangeCapacity() {
        Basket basket = new Basket(10);
        basket.setCapacity(11);

        Assertions.assertEquals(11, basket.getCapacity());
        Assertions.assertEquals(11, basket.getRemainingCapacity());
        Assertions.assertEquals(false, basket.isFull());
    }

    @Test
    public void testAddingItemToBasket() {
        Basket basket = new Basket(10);
        Inventory inventory = new Inventory();
        Item item = inventory.getItem("BGLO");

        Assertions.assertEquals(true, basket.addItem(item, inventory));
    }

    // look over
    @Test
    public void testRemovingItemFromBasket() {
        Basket basket = new Basket(10);
        Inventory inventory = new Inventory();
        Item item1 = inventory.getItem("BGLO");
        Item item2 = inventory.getItem("BGLP");
        basket.addItem(item1, inventory);
        basket.addItem(item2, inventory);

        Assertions.assertEquals(true, basket.removeItem(item1));
        Assertions.assertEquals(false, basket.containsItem(item1));
        Assertions.assertEquals(true, basket.containsItem(item2));
    }

    @Test
    public void testAddingIfBasketFull() {
        Basket basket = new Basket(1);
        Inventory inventory = new Inventory();
        Item item1 = inventory.getItem("BGLO");
        Item item2 = inventory.getItem("BGLP");
        basket.addItem(item1, inventory);

        Assertions.assertEquals(false, basket.addItem(item2, inventory));
    }

    // look over
    @Test
    public void testRemovingIfItemDontExistOrBasketEmpty() {
        Basket basket = new Basket(10);
        Inventory inventory = new Inventory();
        Item item = inventory.getItem("BGLO");

        Assertions.assertEquals(false, basket.removeItem(item));
    }

    @Test
    public void testTotalCostOfItemsInBasket() {
        Basket basket = new Basket(3);
        Inventory inventory = new Inventory();
        Item item1 = inventory.getItem("BGLO");
        Item item2 = inventory.getItem("FILB");
        Item item3 = inventory.getItem("COFB");

        basket.addItem(item1, inventory);
        basket.addItem(item2, inventory);
        basket.addItem(item3, inventory);

        double totalCost = basket.calculateTotalCost();
        Assertions.assertEquals(1.60, totalCost);
    }

    @Test
    public void testGetCostOfOneItem() {
        Basket basket = new Basket(2);
        Inventory inventory = new Inventory();
        Item item1 = inventory.getItem("FILX");

        Assertions.assertEquals(0.12, item1.getPrice());
    }

    @Test
    public void testChoseFillings() {
        Inventory inventory = new Inventory();
        Bagel bagel = (Bagel) inventory.getItem("BGLO");
        Fillings bacon = (Fillings) inventory.getItem("FILB");

        bagel.addFillings(bacon);

        Assertions.assertEquals(true, bagel.getFillings().contains(bacon));
        Assertions.assertEquals(0.61, bagel.getPrice(), 0.01); // 0.49 + 0.12
    }

    @Test
    public void testOnlyOrderThingsInInventory() {
        Inventory inventory = new Inventory();
        Customer customer = new Customer("Alice");

        Bagel fakeBagel = new Bagel("XXXX", 9.99, "Fake", "Invalid");

        boolean result = customer.addItemToBasket(fakeBagel, inventory);
        Assertions.assertEquals(false, result);
    }

    // look over
    @Test
    public void testManagerChangeCapacityOfBaskets() {
        Manager manager = new Manager("Bob");
        Basket basket = new Basket(2);
        manager.changeCapacityOfBaskets(10);

        Assertions.assertEquals(10, basket.getCapacity());
    }

    @Test
    public void testCustomerViewPriceBeforeAdding() {
        Inventory inventory = new Inventory();
        Item item = inventory.getItem("BGLP");

        Assertions.assertEquals(0.39, item.getPrice(), 0.01);
    }
}