package org.uplift.ordermanagement;

import java.util.ArrayList;

public class OrderManagement {
    private ArrayList<Order> order;

    public OrderManagement(ArrayList<Order> order) {
        this.order = order;
    }

    public ArrayList<Order> getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "OrderManagement{" +
                "order=" + order +
                '}';
    }
}
