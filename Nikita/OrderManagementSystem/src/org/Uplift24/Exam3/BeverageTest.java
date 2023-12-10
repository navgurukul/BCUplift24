package org.Uplift24.Exam3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    private Beverage b1=null;
    private Beverage b2=null;

    @BeforeEach
    void setUpData(){
        b1=new Beverage("Brand1",500,"orange",100);
        b2=new Beverage("Brand2",1500,"pineapple",530);
    }
    @AfterEach
    void  tearDown(){
        b1=null;
        b2=null;
    }
    @Test
    void testGetDiscountApplied(){
        assertEquals(20,b1.getDiscountApplied());
    }

    @Test
    void testToString(){
        String result=b1.toString();
        assertTrue(result.contains("Brand1"));
        assertTrue(result.contains("orange"));

        assertTrue(result.contains(Integer.toString(100)));

    }

}