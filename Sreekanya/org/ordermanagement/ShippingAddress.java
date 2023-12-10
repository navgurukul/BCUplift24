package org.ordermanagement;

import java.util.Map;

public class ShippingAddress {
    public static String city;
    public static Map<String,String> shippingCities;
    public ShippingAddress(String city){
        this.city=city;
    }
    public String getCity(){
        return city;
    }
    public  String  getShippingAddress(String city) {
        if (city.equals("Chennai") || (city.equals("Bangalore"))) {
            shippingCities.put(city, "South Zone");
        } else if (city.equals("Mumbai") || (city.equals("goa"))) {
            shippingCities.put(city,"West Zone");
        } else if (city.equals("Kolkatta") || (city.equals("Bhuvaneswar"))) {
            shippingCities.put(city, "East Zone");
        } else if ((city.equals("Delhi") || (city.equals("Noida")))) {
            shippingCities.put(city,"North Zone");
        }
        return null;

    }
    public static Map<String,String> getShippingCities(){
        return shippingCities;
    }
    public static String getShippingZone(){
        return shippingCities.get(city);
    }

}
