package org.order_manger;

import org.orders.Order;
import org.orders.ShippingAddress;

import java.util.*;

public class OrderManagement {
    private ArrayList<Order> orders;
    private Set<String> uniqueShipedCities;

    public OrderManagement(){
        orders = new ArrayList<>();
        uniqueShipedCities = new HashSet<>();
    }

    public void addOrders(Order order){
        orders.add(order);
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public Set<String> getUniqueShipedCities(){
        uniqueShipedCities.addAll(ShippingAddress.zone.keySet());
        return uniqueShipedCities;
    }
}
