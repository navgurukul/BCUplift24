package org.uplift.exam3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postcode;
    Map<String, String> cityZoneMap = new HashMap<>();
    final static String east = "EAST";
    final static String west = "WEST";
    final static String north = "NORTH";
    final static String south = "SOUTH";

    public ShippingAddress(String address, String area, String city, long postcode) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
    }

    public void addtoMap() {
        if (city.equals("Chennai") || (city.equals("Bangalore"))) {
            cityZoneMap.put(city,south);
        }
        else if (city.equals("Mumbai") || (city.equals("Goa"))) {
            cityZoneMap.put(city,west);
        }
        else if (city.equals("Kolkata") || (city.equals("Bhuvaneshwar"))) {
            cityZoneMap.put(city,east);
        }
        else {
            cityZoneMap.put(city,north);
        }
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

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                ", cityZoneMap=" + cityZoneMap +
                '}';
    }
}
