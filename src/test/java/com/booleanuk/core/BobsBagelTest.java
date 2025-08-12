package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BobsBagelTest {

    @Test
    public void testAddingItemToBasket() {
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Item item = inventory.getItem("BGLP");
        basket.setCapacity(2); // must include this because capacity variable in Basket class is static
        basket.addItem(item, inventory);

        Assertions.assertEquals(1, basket.getRemainingCapacity());
        Assertions.assertEquals(true, basket.containsItem(item));

        Item item1 = new Item("test", 1.0, "test", "test");
        basket.addItem(item1, inventory);

        Assertions.assertEquals(false, basket.containsItem(item1));
    }

    @Test
    public void testRemovingItemFromBasket() {
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Item item1 = inventory.getItem("BGLO");
        Item item2 = inventory.getItem("BGLP");
        basket.addItem(item1, inventory);
        basket.addItem(item2, inventory);

        Assertions.assertEquals(true, basket.containsItem(item1));
        Assertions.assertEquals(true, basket.containsItem(item2));

        basket.removeItem(item1);
        Assertions.assertEquals(false, basket.containsItem(item1));
    }

    @Test
    public void testAddingIfBasketFull() {
        Basket basket = new Basket();
        basket.setCapacity(2);
        Inventory inventory = new Inventory();
        Item item1 = inventory.getItem("BGLO");
        Item item2 = inventory.getItem("BGLP");
        Item item3 = inventory.getItem("BGLE");
        basket.addItem(item1, inventory);
        basket.addItem(item2, inventory);

        Assertions.assertEquals(0, basket.getRemainingCapacity());

        basket.addItem(item3, inventory);
        Assertions.assertEquals(false, basket.containsItem(item3));
    }

    // look over
    @Test
    public void testRemovingIfItemDontExistOrBasketEmpty() {
        Basket basket = new Basket();
        basket.setCapacity(2);
        Inventory inventory = new Inventory();
        Item item = inventory.getItem("BGLO");

        basket.addItem(item, inventory);
        Assertions.assertEquals(1, basket.getRemainingCapacity());

        basket.removeItem(item);
        Assertions.assertEquals(2, basket.getRemainingCapacity());
    }

    @Test
    public void testTotalCostOfItemsInBasket() {
        Basket basket = new Basket();
        Inventory inventory = new Inventory();
        Item item1 = inventory.getItem("BGLO");
        Item item2 = inventory.getItem("FILB");

        basket.addItem(item1, inventory);
        basket.addItem(item2, inventory);

        double totalCost = basket.calculateTotalCost();
        Assertions.assertEquals(0.61, totalCost);
    }

    @Test
    public void testGetCostOfOneItem() {
        Inventory inventory = new Inventory();
        Item item1 = inventory.getItem("FILX");

        Assertions.assertEquals(0.12, item1.getPrice());
    }

    @Test
    public void testChoseAndRemoveFillings() {
        Inventory inventory = new Inventory();
        Bagel bagel = (Bagel) inventory.getItem("BGLO");
        Fillings bacon = (Fillings) inventory.getItem("FILB");

        bagel.addFillings(bacon);

        Assertions.assertEquals(true, bagel.getFillings().contains(bacon));

        bagel.removeFillings(bacon, inventory);
        Assertions.assertEquals(0, bagel.getFillings().size());
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
        Basket basket = new Basket();
        manager.changeCapacityOfBaskets(10);

        Assertions.assertEquals(10, manager.basket.getCapacity());
    }

    @Test
    public void testCustomerViewPriceBeforeAdding() {
        Inventory inventory = new Inventory();
        Customer cust = new Customer("Bob");
        Item item = inventory.getItem("BGLP");

        Assertions.assertEquals(0.39, cust.viewCostBeforeAdding(item));
    }

}