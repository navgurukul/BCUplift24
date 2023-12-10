package org.orderManagement.orderdetails;

import org.orderManagement.product.Product;
import org.orderManagement.zone.ShippingAddress;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id ;
    private List<OderIterms> items;
    private ShippingAddress shippingAddress;

    public Order(int id,ShippingAddress shippingAddress ) {
        this.id = id;
        this.items = new ArrayList<>();
        this.shippingAddress = shippingAddress;
    }

    public void addProduct(OderIterms orderiterm){
        //OderIterms orderitem = new OderIterms(product,quantity);
        items.add(orderiterm);

    }
    public List<OderIterms>getItems(){
        return items;
    }

    public ShippingAddress getShippingAddress(){
        return shippingAddress;
    }
    public double getprice(){
        double totalPrice = 0.0;
        for(OderIterms item : items){
            totalPrice+= item.getPrice();
        }
        return totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItems(List<OderIterms> items) {
        this.items = items;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
