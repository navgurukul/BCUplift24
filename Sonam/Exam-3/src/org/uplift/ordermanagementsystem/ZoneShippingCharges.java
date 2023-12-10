package org.uplift.ordermanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class ZoneShippingCharges {
    public static double NORTH_ZONE_CHARGE = 20.0;
    public static double SOUTH_ZONE_CHARGE = 15.0;
    public static double EAST_ZONE_CHARGE = 18.0;
    public static double WEST_ZONE_CHARGE = 17.0;
    private Map<String, Double> ZoneShippingCharges=initializeShippingCharges();

    private Map<String, Double> initializeShippingCharges() {
        Map<String, Double> charges = new HashMap<>();
        charges.put("North", NORTH_ZONE_CHARGE);
        charges.put("South", SOUTH_ZONE_CHARGE);
        charges.put("East", EAST_ZONE_CHARGE);
        charges.put("West", WEST_ZONE_CHARGE);
        return charges;
    }

    public double getShippingChargeForZone(String zone) {
        double charge = 0.0;
        if (ZoneShippingCharges.containsKey(zone)) {
            charge = ZoneShippingCharges.get(zone);
        }

        return charge;
    }
}

