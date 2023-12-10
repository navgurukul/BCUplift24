package org.ordermanagementsystem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderManagement {
    List<Order> orders ;
    Set<String> uniqueShippedCities = new HashSet<>();

    public OrderManagement(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public Set<String> getUniqueShippedCities(){
        return uniqueShippedCities ;
    }
}
