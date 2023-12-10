package order.shippingaddress;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingAddressTest {

    @Test
    void testGetZone() {
        ShippingAddress shippingAddress = new ShippingAddress("NavGurukul " +
                "Sarjapur Campus", "HalnayakanHalli", "Bangalore", 110062);

        ShippingAddress shippingAddress1 = new ShippingAddress("NavGurukul " +
                "Delhi Campus", "Dwarka", "Delhi", 110062);

        ShippingAddress shippingAddress2 = new ShippingAddress("NavGurukul " +
                "Kolkata Campus", "somewhere in Kolkata", "Kolkata", 110062);

        ShippingAddress shippingAddress3 = new ShippingAddress("NavGurukul " +
                "Mumbai Campus", "somewhere in Mumbai", "Mumbai", 110062);

        ShippingAddress shippingAddress4 = new ShippingAddress("NavGurukul " +
                "Tripura Campus", "somewhere in Tripura", "Tripura", 110062);

        assertEquals("South", shippingAddress.getZone());
        assertEquals("North", shippingAddress1.getZone());
        assertEquals("East", shippingAddress2.getZone());
        assertEquals("West", shippingAddress3.getZone());
        assertEquals("No Delivery Zone", shippingAddress4.getZone());
    }
}