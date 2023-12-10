package org.uplift.exam3;

import java.util.*;

public class OrderManagement {
    List<Order> orders = new ArrayList<>();
    Set<String> uniqueShippingCities = new TreeSet<>();

    public void addOrder(Order order) {
        orders.add(order);
    }
    public List<Order> getOders() {
        return orders;
    }

    public Set<String> getUniqueShippedCities() {
        for (Order order : orders) {
            if (!uniqueShippingCities.contains(order.getShippingAddress().getCity())) {
                uniqueShippingCities.add(order.getShippingAddress().getCity());
                System.out.println(order);
            }
        }
        return uniqueShippingCities;
    }

}
