package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BobsBagelTest {

    @Test
    public void testSetCapacity() {
        Basket basket = new Basket(10);
        basket.setCapacity(11);

        Assertions.assertEquals(11, basket.getCapacity());
        Assertions.assertEquals(11, basket.getRemainingCapacity());
        Assertions.assertEquals(false, basket.isFull());
    }
}
