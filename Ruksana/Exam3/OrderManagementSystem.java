package org.exam3;
import java.util.HashSet;
import java.util.Set;

//public class OrderManagement {
//}
//orders:List<Order>
//+getOrders():List<Order>
//+getUniqueSHippedCities:Set>String>
public class OrderManagementSystem {
    Set<Order> orders;

    public OrderManagementSystem() {
        orders = new HashSet<>();

    }

    public void placeOrder(Product product, int quantity, String shippingAddress) {
        Order order = new Order(product, quantity, shippingAddress);
        orders.add(order);
    }

    public void printUniqueShippedCities() {
        Set<String> shippedCities = new HashSet<>();
        for (Order order : orders) {
            shippedCities.add(order.shippingAddress);
        }

        System.out.println("Uniquely Shipped Cities:");
        for (String city : shippedCities) {
            System.out.println(city);
            //System.out.println(order);
        }
    }
}