package system.management.order;
import java.util.Map;
public class CityZoneMap {
    private Map<String,String>cityZoneMap;
    public CityZoneMap(Map<String, String> cityZoneMap) {
        this.cityZoneMap = cityZoneMap;
    }

    public Map<String, String> getCityZoneMap() {
        return cityZoneMap;
    }
}
