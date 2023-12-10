package org.uplift.orderMangement;

public class ShippingAddress extends Order{
    private String address;
    private String city;
    private String area;
    private long postcode;
    private String zone;

    public ShippingAddress(String address, String city, String area, long postcode, String zone) {
        this.address = address;
        this.city = city;
        this.area = area;
        this.postcode = postcode;
        this.zone = zone;
    }

    public String getAddress() {

        return address;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {

        return area;
    }

    public long getPostcode() {
        return postcode;
    }

    public String getZone() {
        return zone;
    }
}
