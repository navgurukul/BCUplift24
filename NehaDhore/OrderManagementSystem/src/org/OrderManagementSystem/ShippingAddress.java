package org.OrderManagementSystem;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postcode;
    public static final String EAST = "East";
    public static final String WEST  = "West";
    public static final String NORTH = "North";
    public static final String SOUTH = "South";


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
}
