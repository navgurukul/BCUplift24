package org.orderManagement.orderdetails;

import org.orderManagement.zone.Zone;

import java.util.HashMap;
import java.util.Map;

public class ZoneShippingCharges {
    private Map <Zone, Double>zoneShippingCharges = new HashMap();
    public ZoneShippingCharges(){
        zoneShippingCharges.put(Zone.EAST,40.0);
        zoneShippingCharges.put(Zone.WEST, 30.0);
        zoneShippingCharges.put(Zone.SOUTH,35.0);
        zoneShippingCharges.put(Zone.NORTH,30.0);

    }
    public double getShippingChargesForZone(){
        return zoneShippingCharges.getOrDefault(zoneShippingCharges,0.0);
    }
}
