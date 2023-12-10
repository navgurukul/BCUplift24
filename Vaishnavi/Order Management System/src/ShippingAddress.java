import java.util.HashMap;
import java.util.Map;

public class ShippingAddress {

    private String address;
    private String area;
    private String city;
    private long postcode;
    private String zone;

    Map<String,String> CityZoneMap = new HashMap<>();

    public ShippingAddress(String address, String area, String city, long postcode, String zone) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
        this.zone = zone;
        CityZoneMap.put(this.city,this.zone);
    }

    public String getAddress() {
        return address;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public long getPostcode() {
        return postcode;
    }

    public String getZone() {
        return zone;
    }

    public Map<String, String> getCityZoneMap() {
        return CityZoneMap;
    }

    @Override
    public String toString() {
        return
                "\n"+"address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                ", zone='" + zone + '\'' +
                "}";
    }


}
