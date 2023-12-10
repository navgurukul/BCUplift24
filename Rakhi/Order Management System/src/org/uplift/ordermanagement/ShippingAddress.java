package org.uplift.ordermanagement;

import java.util.HashMap;
import java.util.Map;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postCode;
    private String zone;

    public static final String North="N";
    public static final String South="S";
    public static final String East="E";
    public static final String West="W";

    public ShippingAddress(String address, String area, String city, long postCode,String zone) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postCode = postCode;
        this.zone=zone;
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

    public long getPostCode() {
        return postCode;
    }

    public String getZone() {
        return zone;
    }

    Map<String,String> cityZoneMap=new HashMap<>();

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", postCode=" + postCode +
                ", zone='" + zone + '\'' +
                ", cityZoneMap=" + cityZoneMap +
                '}';
    }
}
