package org.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    @Test
    void testForToString() {
        Beverage be1=new Beverage("sugar Water",1233,"lemon",100);

        assertEquals("sugar Water", be1.getMake());

    }
    @Test

    void testForDiscountApplied(){
        Beverage be1=new Beverage("sugar Water",1233,"lemon",100);
        assertEquals(20.0,be1.getDiscountApplied());
    }
    @Test

    void testForPrice(){
        Beverage be1=new Beverage("sugar Water",1233,"lemon",100);
        assertEquals(80.0,be1.getPrice());
    }

}