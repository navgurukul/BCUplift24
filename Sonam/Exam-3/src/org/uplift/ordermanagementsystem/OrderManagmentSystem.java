package org.uplift.ordermanagementsystem;

import java.util.ArrayList;
import java.util.List;


public class OrderManagmentSystem {
    private List<Order> orders = new ArrayList<>();
    private CityZoneMap cityZoneMap;
    private ZoneShippingCharges zoneShippingCharges;
    List<Order> allOrders = new ArrayList<>();


    public OrderManagmentSystem(CityZoneMap cityZoneMap, ZoneShippingCharges zoneShippingCharges) {
        this.cityZoneMap = cityZoneMap;
        this.zoneShippingCharges = zoneShippingCharges;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        allOrders.add(order);
    }

    public void getallOrders() {
        for (Order i : allOrders) {
            System.out.println("Order ID: " + i.getId());
            System.out.println("Shipping Address: " + i.getShippingAddress());
            System.out.println("Items: " + i.getItems());
            System.out.println("Product price after offer :"+i.getPrice());
            System.out.println("Total Price: " + i.getTotalPrice());

            System.out.println("\n");
        }
    }
}


