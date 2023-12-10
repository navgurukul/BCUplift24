package org.orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingAddressTest {

    ShippingAddress sa = null;
    @BeforeEach
    public void startUp(){
        sa = new ShippingAddress("G-55", "Sangam Vihar", "Delhi", 110090);
    }

    @Test
    public void getShippingAddressTest(){
        assertTrue(sa.getShippingAddress().containsKey(sa.getCity()));
    }

}