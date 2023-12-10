package org.uplift.orderMangement;

import java.util.List;

public class Order extends OrderManagement{
    private long id;
    private List<OrderItems> items;

    public long getId() {
        return id;
    }

    public List<OrderItems> getItems() {
        return items;
    }

    public void addProduct(Product product){

    }
    public String getShippingAddress(){
        return "1";

    }

    public double getPrice(){
        return 1;

    }








}
