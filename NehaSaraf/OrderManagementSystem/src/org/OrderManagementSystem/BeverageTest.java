package org.OrderManagementSystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    private Beverage b1=null;

    @BeforeEach
    void setUp(){
        b1=new Beverage(22,60,"PaperBoat",1000,"Kaccha Mango");
    }
    @AfterEach
    void tearDown(){
        b1=null;
    }
    @Test
    void testGetProductDescription() {
        String s=b1.getProductDescription();
        assertTrue(s.contains("PaperBoat"));
        assertTrue(s.contains("Kaccha Mango"));

    }

    @Test
    void testToString() {
        String result=b1.toString();
        assertTrue(result.contains("PaperBoat"));
        assertTrue(result.contains("Kaccha Mango"));
        assertTrue(result.contains("1000"));
    }

}