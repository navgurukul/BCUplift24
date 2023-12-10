package orderManagement;

import order.Order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OrderManagement {
    ArrayList<Order> orders;
    Set<String> uniqueShippedCities;

    public OrderManagement() {
        orders = new ArrayList<>();
        uniqueShippedCities = new HashSet<>();
    }

    public void placeOrder(Order order){
        orders.add(order);
        uniqueShippedCities.add(order.getShippingAddress().getCity());
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public Set<String> getUniqueShippedCities() {
        return uniqueShippedCities;
    }
}
