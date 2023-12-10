package org.uplift.ordermanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    Product p=new Beverage("ABC",100,"CDE",100);

    @Test
    void getDiscountApplied() {
        double discount=20;
        assertEquals(20,p.getDiscountApplied());
    }

    @Test
    void getProductDescription() {
        String result=p.getProductDescription();
        assertTrue(result.contains("ABC"));
        assertTrue(result.contains("100"));
        assertTrue(result.contains("CDE"));
        assertTrue(result.contains("100"));
    }
}