package org.uplift;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    Beverage b1;
    @BeforeEach
    void setUpData(){
        b1 = new Beverage(1,100,20,"abc",10,"Orange");
    }

    @Test
    void getProductDescription() {
          assertTrue(b1.getProductDescription().contains("abc"));
    }

    @Test
    void getDiscountApplied() {
        double a = b1.getPrice() -( b1.getPrice() * b1.getDiscountPercentage() / 100);
        System.out.println(a);
    }
    @Test
    void getNetPrice(){
        assertEquals(80.0,b1.getDiscountApplied());
    }
}