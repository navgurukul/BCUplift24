package OnlineShopping;

import java.util.*;

public class OrderManagement {
    private List<Order> orderList;
    private SortedSet<String> uniqueShippedCitites;
    private Map<String, Double> zoneShippingCharges;
    private Map<String, String> cityZoneMap;


    public OrderManagement() {
        this.orderList = new ArrayList<>();
        this.uniqueShippedCitites = new TreeSet<>();
        this.zoneShippingCharges = new HashMap<>();
        this.cityZoneMap = new HashMap<>();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public SortedSet<String> getUniqueShippedCitites() {
        return uniqueShippedCitites;
    }

    public Map<String, Double> getZoneShippingCharges() {
        return zoneShippingCharges;
    }


    public Map<String, String> getCityZoneMap() {
        return cityZoneMap;
    }


    public void getShippingAddress(ShippingAddress s) {
        System.out.println(s);
    }



    public boolean addTouniqueShippedCitites(ShippingAddress s) {
        if (!uniqueShippedCitites.contains(s.getCity())) {
            return uniqueShippedCitites.add(s.getCity());
        } else {
            return false;
        }
    }



/*public  addToCityZoneMap(ShippingAddress s) {
    if (!cityZoneMap.containsKey(s.getCity())) {
        cityZoneMap.put(s.getCity(),s.getZone());             //String.valueOf(c))
    }
    else{
        System.out.println("city already exitst");
    }
    return cityZoneMap;
} */





    @Override
    public String toString() {
        return "OrderManagement{" +
                "orderList=" + orderList +
                ", uniqueShippedCitites=" + uniqueShippedCitites +
                ", zoneShippingCharges=" + zoneShippingCharges +
                '}';
    }
}
