package org.uplift;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    private Beverage b1;
    @BeforeEach
    void setupDate(){
        b1=new Beverage(10,"PaperBoat",1000,"Nimbu",50.);
    }


    @Test
    void getProductDescription() {
        String ans= b1.getProductDescription();
        assertTrue(ans.contains("Nimbu"));
    }

    @Test
    void getDiscountApplied() {
        double ans= b1.getDiscountApplied();
        assertEquals(10,ans);
    }

    @Test
    void netPrice() {
        double ans= b1.netPrice();
        assertEquals(40,ans);
        }
    }
