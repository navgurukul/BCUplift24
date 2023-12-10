package org.uplift;
import java.util.ArrayList;
import java.util.List;

public class OrderManagement {
    List<Order>orders=new ArrayList<>();

    public OrderManagement(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
