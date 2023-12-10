package org.uplift;

import java.util.*;



public class Order {
    private long id;
    private List<OrderItems> orderItemsList;
    private Map<String, Double> zoneShippingCharges = new HashMap<>();
    private ShippingAddress sa;

    public Order(long id, List<OrderItems> orderItemsList, ShippingAddress sa) {
        this.id = id;
        this.orderItemsList = orderItemsList;
        this.sa = sa;
    }

    public long getId() {
        return id;
    }

    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }

    public ShippingAddress getShippingAddress() {
        return sa;
    }


    public void addShippingCharge(String zone, double charge) {
        zoneShippingCharges.put(zone, charge);
    }
}
