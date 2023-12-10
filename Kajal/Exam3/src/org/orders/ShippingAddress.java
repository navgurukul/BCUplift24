package org.orders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postCode;
    public static final String EAST = "East";
    public static final String WEST = "West";
    public static final String NORTH = "North";
    public static final String SOUTH = "South";
    public static Map<String, String> zone = new HashMap<>();

    public ShippingAddress(String address, String area, String city, long postCode) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postCode = postCode;
        addZone();
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public long getPostCode() {
        return postCode;
    }

    public String getAddress() {
        return address;
    }

    private void addZone(){
        ArrayList<String> north = new ArrayList<>(Arrays.asList("Delhi", "Noida"));
        ArrayList<String> south = new ArrayList<>(Arrays.asList("Chennai", "Bangalore"));
        ArrayList<String> east = new ArrayList<>(Arrays.asList("Kolkatta", "Bhuvaneshwar"));
        ArrayList<String> west = new ArrayList<>(Arrays.asList("Mumbai", "Goa"));

        if (north.contains(city))
            zone.put(getCity(), NORTH);
        else if (east.contains(city))
            zone.put(getCity(), EAST);
        else if (west.contains(city))
            zone.put(getCity(), WEST);
        else if (south.contains(city))
            zone.put(getCity(), SOUTH);

    }

    public Map<String, String> getShippingAddress(){
        return zone;
    }

}
