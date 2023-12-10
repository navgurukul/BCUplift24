package org.OrderManagementSystem;

import java.util.*;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postcode;

    public ShippingAddress(String address, String area, String city, long postcode) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
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
    Map<String, String> zoneMap=new HashMap<>();
    List<String> southZoneCityList= Arrays.asList("Bangalore","Chennai");
    List<String> westZoneCityList=Arrays.asList("Mumbai","Goa");
    List<String> eastZoneCityList=Arrays.asList("Kolkatta","Bhuvaneshwar");
    List<String> northZoneCityList=Arrays.asList("Delhi","Noida");

    public static final String SOUTH_ZONE="SZ";
    public static final String WEST_ZONE="WZ";
    public static final String EAST_ZONE="EZ";
    public static final String NORTH_ZONE="NZ";

    public void ShippingAddressZone(){
        if(city.equals("Bangalore")||city.equals("Chennai")){
            zoneMap.put(SOUTH_ZONE,city);
        }
        else if(city.equals("Mumbai")||city.equals("Goa")){
            zoneMap.put(WEST_ZONE,city);
        }
        else if(city.equals("Kolkatta")||city.equals("Bhuvaneshwar")){
            zoneMap.put(EAST_ZONE,city);
        } else if (city.equals("Delhi")||city.equals("Noida")) {
            zoneMap.put(NORTH_ZONE,city);
        }
    }

    public Map<String, String> getZoneMap() {
        return zoneMap;
    }

    public List<String> getSouthZoneCityList() {
        return southZoneCityList;
    }

    public List<String> getWestZoneCityList() {
        return westZoneCityList;
    }

    public List<String> getEastZoneCityList() {
        return eastZoneCityList;
    }

    public List<String> getNorthZoneCityList() {
        return northZoneCityList;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                '}';
    }
}
