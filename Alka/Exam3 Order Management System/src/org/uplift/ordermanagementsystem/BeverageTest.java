package org.uplift.ordermanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {


    @Test
    void testToString() {
        Beverage beverage1 = new Beverage("Chocolate Shake", 1000, "Chocolate");
        String result = beverage1.toString();
        assertFalse(result.contains(beverage1.getProductDescription()));

    }
}