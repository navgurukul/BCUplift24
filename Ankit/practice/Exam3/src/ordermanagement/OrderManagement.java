package ordermanagement;

import ordermanagement.order.Order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderManagement {
    List<Order> orders = new ArrayList<>() ;
    Set<String> uniqueShippedCities = new HashSet<>();

    public void placeOrder(Order order){
        orders.add(order);
        uniqueShippedCities.add(order.getShippingAddress().getCity());
    }

    public List<Order> getOrders() {
        return orders;
    }
    public Set<String> getUniqueShippedCities(){
        return uniqueShippedCities ;
    }
}
