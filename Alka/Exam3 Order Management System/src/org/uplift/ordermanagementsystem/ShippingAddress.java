package org.uplift.ordermanagementsystem;

import java.util.HashMap;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long pastcode;

    private Zone zone;

    HashMap<String,Zone>  cityZone = new HashMap<>();

    @Override


    public String getAddress() {
        return address;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public long getPastcode() {
        return pastcode;
    }

    public ShippingAddress(String address, String area, String city, long pastcode) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.pastcode = pastcode;
    }
    public String toString() {
        return "ShippingAddress{" +
                "address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", pastcode=" + pastcode +
                '}';
    }
}
