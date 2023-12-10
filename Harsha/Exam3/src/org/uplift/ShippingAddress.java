package org.uplift;

import java.util.HashMap;
import java.util.Map;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postcode;
    private String zone;
    Map<String,String> cityZoneMap;

    public ShippingAddress(String address, String area, String city, long postcode, String zone) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
        this.zone = zone;
        //this.cityZoneMap =new HashMap<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPostcode() {
        return postcode;
    }

    public void setPostcode(long postcode) {
        this.postcode = postcode;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "ShippingAddress{" +
                "address='" + address + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                ", zone='" + zone + '\'' +
                '}';
    }
}



