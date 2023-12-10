package org.OrderManagementSystem;

import java.util.List;

public class Order {
    private long id;
    List<OrderItem> items;
    private int shippingPrice;

    public Order(long id, List<OrderItem> items, int ShippingPrice) {
        this.id = id;
        this.items = items;
        this.shippingPrice = shippingPrice;
    }

    public void addProduct(OrderItem product){
        items.add(product);
    }

//    public String getShippingAddress(){
//        return ShippingAddress.toString();
//    }

    public List<OrderItem> getItems(){
        return items;
    }

    public double getPrice(){
        double total = 0;
        for(OrderItem product : getItems()){
            total = product.getPrice();
        }
        return total + shippingPrice;
    }
}
