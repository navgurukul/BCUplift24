package org.uplift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private int orderId;
    private List<OrderItem> items;
    private ShippingAddress shippingAddress;


    public Order(int orderId, ShippingAddress shippingAddress) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.shippingAddress = shippingAddress;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void addProduct(OrderItem o1) {

        items.add(o1);
        //System.out.println(o1 +"is added to items ");
    }

    public List<OrderItem> getItems() {
        return items;
    }


    double a;
    double s=0;

    public double getPrice() {
        double charge = Double.parseDouble(getShippingAddress().cityZoneMap.get(shippingAddress.getZone()));
        for (OrderItem p : items) {


            Product p1 = (Product) p.getProduct();
            s = s + p1.netPrice() * p.getQuantity();
        }
        return s + charge;
    }

}
