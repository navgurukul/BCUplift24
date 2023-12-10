package org.uplift.ordermanagementsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneShippingChargesTest {
    @Test
    public void testShippingChargesInitialization() {
        ZoneShippingCharges z= new ZoneShippingCharges();

        assertEquals(20.0, z.NORTH_ZONE_CHARGE);
        assertEquals(15.0, z.SOUTH_ZONE_CHARGE);
        assertEquals(18.0, z.EAST_ZONE_CHARGE);
        assertEquals(17.0, z.WEST_ZONE_CHARGE);
    }

    @Test
    public void testGetShippingChargeForZone() {
        ZoneShippingCharges z = new ZoneShippingCharges();

        assertEquals(20.0, z.getShippingChargeForZone("North"));
        assertEquals(15.0, z.getShippingChargeForZone("South"));
        assertEquals(18.0, z.getShippingChargeForZone("East"));
        assertEquals(17.0, z.getShippingChargeForZone("West"));
    }

    @Test
    public void testGetShippingChargeForInvalidZone() {
        ZoneShippingCharges z = new ZoneShippingCharges();
        assertEquals(0.0, z.getShippingChargeForZone("InvalidZone"));
    }

}
