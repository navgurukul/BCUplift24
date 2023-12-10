package org.ordermanagementsystem;

import java.util.HashMap;
import java.util.Map;

public class ShippingAdress {
    private String address;
    private String area;
    private String city;
    private long postcode ;
    private String zone ;
    Map<String,String> cityZoneMap = new HashMap<>();

    public static final String EAST = "east";
    public static final String WEST = "west";
    public static final String NORTH = "north";
    public static final String SOUTH = "south";
    public ShippingAdress(String address, String area, String city, long postcode, String zone) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
        this.zone = zone;
    }

    public void getIntoCityZoneMap(){
        cityZoneMap.put(city,zone);
    }
}
