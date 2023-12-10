package org.ordermanagementsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private long id;
    List<OrderItems> items = new ArrayList<>();
    Map<String,Double> zoneShippingCharges = new HashMap<>();

    public Order(long id) {
        this.id = id;
        zoneShippingCharges.put("South",100.0);
        zoneShippingCharges.put("North",105.0);
        zoneShippingCharges.put("West",70.0);
        zoneShippingCharges.put("East",110.0);
    }

    public void addProduct(OrderItems product){
        items.add(product);
    }
    public void getShippingAddress(){

    }
    public List<OrderItems> getItems(){
        return items ;
    }
    public double getPrice(){
        return 0;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }

    public long getId() {
        return id;
    }
}
