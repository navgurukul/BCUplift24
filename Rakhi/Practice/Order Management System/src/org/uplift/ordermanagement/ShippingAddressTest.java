package org.uplift.ordermanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingAddressTest {

    ShippingAddress sa=new ShippingAddress("ABC","CDE","EFG",1234,"S");
    @Test
    void testToString() {
        String result=sa.toString();
        assertTrue(result.contains("ABC"));
        assertTrue(result.contains("CDE"));
        assertTrue(result.contains("EFG"));
        assertTrue(result.contains("1234"));
        assertTrue(result.contains("S"));
    }
}