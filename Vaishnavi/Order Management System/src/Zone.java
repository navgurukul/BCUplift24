import java.util.HashMap;
import java.util.Map;

public class Zone {

    public static final String EAST = "east";
    public static final String WEST = "west";
    public static final String NORTH ="north";
    public static final String SOUTH = "south";

    Map<String,String> CityZoneMap = new HashMap<>();
    Map<String,Double> ZoneShippingCharges = new HashMap<>();


    public Zone() {
        ZoneShippingCharges.put(EAST,10.0);
        ZoneShippingCharges.put(WEST,5.0);
        ZoneShippingCharges.put(NORTH,15.0);
        ZoneShippingCharges.put(SOUTH,20.0);

    }

    public Map<String, Double> getZoneShippingCharges() {
        return ZoneShippingCharges;
    }
}
