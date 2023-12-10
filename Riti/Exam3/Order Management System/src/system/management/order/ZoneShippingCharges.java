package system.management.order;

import java.util.ArrayList;
import java.util.Map;

public class ZoneShippingCharges {
    private Map<String,Integer>mapOfZoneShippingCharges;

    public ZoneShippingCharges(Map<String, Integer> mapOfZoneShippingCharges) {
        this.mapOfZoneShippingCharges = mapOfZoneShippingCharges;
    }

    public Map<String, Integer> getMapOfZoneShippingCharges() {
        return mapOfZoneShippingCharges;
    }
}
