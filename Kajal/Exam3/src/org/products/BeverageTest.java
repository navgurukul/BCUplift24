package org.products;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.orders.Order;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    public Product p3 = null;
    public Product p4 = null;

    @BeforeEach
    public void startUp(){
        p3 = new Beverage("Tea", 50, "Lemon", 76543, 100.0);
        p4 = new Beverage("Shake", 100, "Banana", 87659, 150.0);
    }

    @Test
    public void getProductDescriptionTest(){
        String result = p3.getProductDescription();
        assertTrue(result.contains("Tea"));
    }

    @Test
    public void getDiscountAppliedTest(){
        assertEquals(20, p3.getDiscountApplied());
    }

    @Test
    public void netPriceTest(){
        assertEquals(100,p3.netPrice());
    }

}