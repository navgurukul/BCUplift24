package org.uplift;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    List<Orderitems>items=new ArrayList<>();

    public Order(long id, List<Orderitems> items) {
        this.id = id;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Orderitems> getItems() {
        return items;
    }

    public void setItems(List<Orderitems> items) {
        this.items = items;
    }
    public void addProduct(Product product){

    }
    public String getShippingAddress(){
        return null;
    }

    Orderitems orderitem=new Orderitems();

}
