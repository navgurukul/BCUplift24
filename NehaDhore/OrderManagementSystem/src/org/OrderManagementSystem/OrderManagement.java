package org.OrderManagementSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderManagement {
    List<Order> orders = new ArrayList<>();
    Set<String> uniqueCities = new HashSet<>();

    public OrderManagement(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public Set<String> getUniqueShippedCities(ShippingAddress s){
        uniqueCities.add(s.getCity());
        return uniqueCities;
    }
}

