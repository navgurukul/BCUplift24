package org.orders;

import org.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private long id;
    ArrayList<OrderItems> orderedItems;
    private Map<String, Double> zoneShippingCharges;
    private String zone;
    public Order(long id){
        this.id = id;
        this.orderedItems = new ArrayList<>();
        this.zoneShippingCharges = new HashMap<>();
        makeZoneShippingChargesMap();
    }

    private void makeZoneShippingChargesMap(){
        zoneShippingCharges.put(ShippingAddress.NORTH, 30.0);
        zoneShippingCharges.put(ShippingAddress.EAST, 50.0);
        zoneShippingCharges.put(ShippingAddress.WEST, 40.0);
        zoneShippingCharges.put(ShippingAddress.SOUTH, 60.0);
    }
    public void addProduct(Product product){
        OrderItems oi = new OrderItems(product, 1);
        orderedItems.add(oi);
    }
    public void getShippingAddress(ShippingAddress address){
        zone = address.getShippingAddress().get(address.getCity());
    }
    public ArrayList<OrderItems> getItems(){
        return orderedItems;
    }
    public double getPrice(){
        double price = 0.0;
        for (OrderItems oi: orderedItems){
            price+=oi.getPrice();
        }

        return price+zoneShippingCharges.get(zone);
    }
}
