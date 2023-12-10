package org.uplift;

import java.util.HashMap;
import java.util.Map;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postcode;
    private String zone;

    private Map<String, ShippingAddress> cityZoneMap = new HashMap<>();

    public ShippingAddress(String address, String area, String city, long postcode, String zone) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
        this.zone = zone;
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

    public void addShippingAddress(ShippingAddress sa) {
        cityZoneMap.put(city, sa);
    }

    public Map<String, ShippingAddress> getCityZoneMap() {
        return cityZoneMap;
    }
}
