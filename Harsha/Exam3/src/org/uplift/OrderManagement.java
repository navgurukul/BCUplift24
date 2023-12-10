package org.uplift;

import java.util.List;
import java.util.Set;

public class OrderManagement {
    private List<Order> orders;

    public OrderManagement(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
//    public Set<String> getUniqueShippedCities(){
//
//    }
}
