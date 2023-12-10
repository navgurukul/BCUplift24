package org.OrderManagementSystem;

import java.util.*;

public class OrderManagement {
    List<Order> orders=new ArrayList<>();
    Set<String> uniqueShippedCities=new TreeSet<>();

    public List<Order> getOrders() {
        return orders;
    }

    public Set<String> getUniqueShippedCities() {
        return uniqueShippedCities;
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public void addUniqueShippingCities(ShippingAddress s){
        uniqueShippedCities.add(s.getCity());
    }

}
