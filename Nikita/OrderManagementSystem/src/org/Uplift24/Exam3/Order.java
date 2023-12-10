package org.Uplift24.Exam3;

import java.util.ArrayList;
import java.util.Objects;

public class Order {
    private long id;
    private ArrayList<OrderItems> items;
    private ShippingAddress shippingAddress;


    public Order(long id, ArrayList<OrderItems> items,ShippingAddress shippingAddress) {
        this.id = id;
        this.items = items;
        this.shippingAddress=shippingAddress;
    }

    public long getId() {
        return id;
    }

    public ArrayList<OrderItems> getItems() {
        return items;
    }

    public void addProduct(OrderItems o){
        items.add(o);
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public double getPrice(){
        double total=0;
        for(OrderItems i:items){
            total=total+i.getPrice()+getShippingAddress().getCityZoneMap().get(getShippingAddress().getCity());
        }
       return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
