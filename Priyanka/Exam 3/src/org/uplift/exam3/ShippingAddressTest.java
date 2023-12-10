package org.uplift.exam3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingAddressTest {

    @Test
    void addtoMap() {
        ShippingAddress sd1 = new ShippingAddress("xyz","yyy","Chennai",1234567);
        sd1.addtoMap();
        assertEquals(sd1.cityZoneMap.size(),1);
    }

    @Test
    void testToString() {
        ShippingAddress sd1 = new ShippingAddress("xyz","yyy","Chennai",1234567);
        String result = sd1.toString();
        assertTrue(result.contains("xyz"));
        assertTrue(result.contains("yyy"));
        assertTrue(result.contains("Chennai"));
        assertTrue(result.contains("1234567"));
    }
}