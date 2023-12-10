package org.uplift;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addShippingCharge() {
        Map<String, Double> zoneShippingCharges = new HashMap<>();
        zoneShippingCharges.put("EAST",80.0);
        zoneShippingCharges.put("WEST",70.0);
        zoneShippingCharges.put("SOUTH",50.0);
        System.out.println(zoneShippingCharges);


    }
}