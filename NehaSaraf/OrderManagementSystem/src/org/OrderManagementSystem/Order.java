package org.OrderManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private List<OrderItems> items;
    private OrderItems orderItems;
    private ShippingAddress shippingAddress;

    public Order(long id,ShippingAddress shippingAddress) {
        this.id = id;
        this.items = new ArrayList<>();
        this.shippingAddress=shippingAddress;
    }

    public long getId() {
        return id;
    }

    public List<OrderItems> getItems() {
        return items;
    }
    public void addProduct(ProductClass product){

    }
    public ShippingAddress getShippingAddress(){
        return shippingAddress;
    }
    public double getPrice() {
        if(shippingAddress.zoneMap.containsKey("SZ")){
            return orderItems.getPrice()+100;
        }
        else if(shippingAddress.zoneMap.containsKey("WZ")){
            return orderItems.getPrice()+80;
        }
        else if(shippingAddress.zoneMap.containsKey("EZ")){
            return orderItems.getPrice()+70;
        }
        else if(shippingAddress.zoneMap.containsKey("NZ")){
            return orderItems.getPrice()+60;
        }
        return orderItems.getPrice();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                ", orderItems=" + orderItems +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
