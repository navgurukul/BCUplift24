package org.order;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private long id;
    private List<OrderItem> orderItemList=new ArrayList<>();

    private Map<String, Double> mapShipingCharges=new HashMap<>();

    public Order(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
    public void addShipingchatges(String zone,double price){
        mapShipingCharges.put(zone,price);
    }
    public void addProduct(OrderItem product){
        orderItemList.add( product);
    }
    public double getPrice(OrderItem orderItem ,String zone){
        if (mapShipingCharges.containsKey(zone)){
            double b=mapShipingCharges.get(zone);
            return orderItem.getPrice()+ b;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderItemList=" + orderItemList +
                ", mapShipingCharges=" + mapShipingCharges +
                '}';
    }
}
