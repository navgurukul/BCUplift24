package org.OrderManagementSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingAddressTest {


    @Test
    void testToString() {
        ShippingAddress address=new ShippingAddress("aaaaaaaaaaaa","bbbbbbbbbb","Mumbai",111111);
        String s=address.toString();
        assertTrue(s.contains("aaaaaaaaaaaa"));
        assertTrue(s.contains("Mumbai"));
        assertTrue(s.contains("111111"));


    }
}