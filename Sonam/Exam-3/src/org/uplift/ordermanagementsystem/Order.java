package org.uplift.ordermanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private List<OrderItem> items=new ArrayList<>();;
    private ShippingAddress shippingAddress;

    public Order(long id, ShippingAddress shippingAddress) {
        this.id = id;
        this.shippingAddress = shippingAddress;
    }

    public long getId() {
        return id;
    }

    public void addProduct(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }
    public double  getPrice(){
        double totalPrice = 0.0;
        for (OrderItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (OrderItem item : items) {
            totalPrice += item.getTotalPrice();
        }
        double shippingCost = getShippingCostForZone(shippingAddress.getZone());
        return totalPrice+ shippingCost;
    }

    private double getShippingCostForZone(String zone) {
        return 0.0;
    }
}
