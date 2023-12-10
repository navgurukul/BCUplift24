package org.order;

import java.util.HashMap;
import java.util.Map;

public class ShipingAddress {
    private String area;
    private String city;
    private String address;
    private long postcode;
    private String zone;

    private Map<String,String> cityZoneMap=new HashMap<>();

    public ShipingAddress(String area, String city, String address, long postcode, String zone) {
        this.area = area;
        this.city = city;
        this.address = address;
        this.postcode = postcode;
        this.zone = zone;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public long getPostcode() {
        return postcode;
    }

    public String getZone() {
        return zone;
    }

    public Map<String, String> getCityZoneMap() {
        return cityZoneMap;
    }

    public void addToCityzoneMap(String city, String zone){
        cityZoneMap.put(city,zone);
    }

    @Override
    public String toString() {
        return "ShipingAddress{" +
                "area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", postcode=" + postcode +
                ", zone='" + zone + '\'' +
                ", cityZoneMap=" + cityZoneMap +
                '}';
    }
}
