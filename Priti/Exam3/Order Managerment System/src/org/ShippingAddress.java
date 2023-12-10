package org;

import java.time.zone.ZoneRules;

public class ShippingAddress {
    private String Address;
    private String area ;
    private String city;
    private Long postCode;
    private String zone;

    public ShippingAddress(String address, String area, String city, Long postCode, String zone) {
        Address = address;
        this.area = area;
        this.city = city;
        this.postCode = postCode;
        this.zone = zone;
    }

}
