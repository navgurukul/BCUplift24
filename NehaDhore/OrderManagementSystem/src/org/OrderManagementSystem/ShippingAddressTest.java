package org.OrderManagementSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingAddressTest {
    ShippingAddress s = new ShippingAddress("MG Square","Mumbai","Kalyan",4004);


    @Test
    void getAddress() {
        assertEquals("MG Square",s.getAddress());
    }

    @Test
    void getCity() {
        assertEquals("Mumbai",s.getCity());
    }

    @Test
    void getArea() {
        assertEquals("Kalyan",s.getArea());
    }

    @Test
    void getPostcode() {
        assertEquals(4004,s.getPostcode());
    }
}