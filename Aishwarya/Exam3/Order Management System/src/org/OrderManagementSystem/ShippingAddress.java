package org.OrderManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class ShippingAddress {

    private String address;
    private String area;
    private String city;
    private long postcode;

    public static final String EAST = "East";
    public static final String WEST = "West";
    public static final String NORTH = "North";

    public static final String SOUTH = "South";

    Map<String, String> cityZoneMap = new HashMap<>();


    public ShippingAddress(String address, String area, String city, long postcode) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;

        cityZoneMap.put(EAST, "Kolkatta, Bhuvaneshwar");
        cityZoneMap.put(WEST, "Mumbai, goa");
        cityZoneMap.put(NORTH, "Delhi, Noida");
        cityZoneMap.put(SOUTH, "Chennai, Bangalore");


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
