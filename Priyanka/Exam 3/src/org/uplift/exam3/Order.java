package org.uplift.exam3;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private OrderItems orderItems;
    private ShippingAddress shippingAddress;

    List<OrderItems> items = new ArrayList<>();

    public Order(long id,OrderItems orderItems,ShippingAddress shippingAddress) {
        this.id = id;
        this.orderItems = orderItems;
        this.shippingAddress = shippingAddress;
    }

    public void addOrderItems(OrderItems orderItems) {
        items.add(orderItems);
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }
    public List<OrderItems> getItems() {
        return items;
    }
    public double getPrice() {
        if (shippingAddress.cityZoneMap.containsValue("SOUTH")) {
            return orderItems.getPrice()+50;
        }
        else if (shippingAddress.cityZoneMap.containsValue("NORTH")) {
            return orderItems.getPrice()+60;
        }
        else if (shippingAddress.cityZoneMap.containsValue("EAST")) {
            return orderItems.getPrice()+80;
        }
        else {
            return orderItems.getPrice()+60;
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderItems=" + orderItems +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
