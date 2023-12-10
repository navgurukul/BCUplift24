package org.Uplift24.Exam3;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

public class ShippingAddress {
    private String address;
    private String city;
    private long postcode;
    private String zone;

    private Map<String,Integer> cityZoneMap=new HashMap<>();

    public ShippingAddress(String address,  String city, long postcode, String zone) {
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.zone = zone;

        cityZoneMap=new HashMap<>();
        cityZoneMap.put("Chennai",200);
        cityZoneMap.put("Bangalore",200);
        cityZoneMap.put("Mumbai",100);
        cityZoneMap.put("goa",100);
        cityZoneMap.put("Kolkatta",400);
        cityZoneMap.put("Bhuvaneshwar",400);
        cityZoneMap.put("Delhi",500);
        cityZoneMap.put("Noida",500);

    }

    public String getAddress() {
        return address;
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
    public Map<String,Integer> getCityZoneMap(){
        return cityZoneMap;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                ", zone='" + zone + '\'' +
                ", cityZoneMap=" + cityZoneMap +
                '}';
    }
}
