package org.uplift.exam3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {

    @Test
    void testToString() {
        Beverage bv1 = new Beverage("PaperBoat",1000,"Nimbu",20,40);
        String result = bv1.toString();
        assertTrue(result.contains("PaperBoat"));
        assertTrue(result.contains("1000"));
        assertTrue(result.contains("Nimbu"));
        assertTrue(result.contains("20"));
        assertTrue(result.contains("40"));
    }
}