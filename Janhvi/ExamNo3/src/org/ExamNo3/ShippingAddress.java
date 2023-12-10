package org.ExamNo3;

import java.util.HashMap;
import java.util.Map;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postcode;
    private  String zone;
    Map <String,String> cityZoneMap;

    public ShippingAddress(String address, String area, String city, long postcode, String zone) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
        this.zone = zone;
        this.cityZoneMap = new HashMap<>();
        cityZoneMap.put(city,zone);
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
        return cityZoneMap;
    }
    public void addTocityZoneMap(){
        cityZoneMap.put(city,zone);
    }

    @Override
    public String toString() {
        return "ShippingAddress {" +
                "address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                ", zone='" + zone + '\'' +
                ", cityZoneMap=" + cityZoneMap +
                '}';
    }
}
