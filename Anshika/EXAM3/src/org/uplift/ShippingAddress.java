package org.uplift;
import org.uplift.Zone;

public class ShippingAddress {
    private String address;
    private String area;
    private String city;
    private long postcode;
    private Zone zone;

    public ShippingAddress(String address, String area, String city, long postcode, Zone zone) {
        this.address = address;
        this.area = area;
        this.city = city;
        this.postcode = postcode;
        this.zone = zone;
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

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
