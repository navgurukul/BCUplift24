package org;

import java.util.List;

public class Order {
    private Long id;
    private List<Orderitems> items;

    public Order(Long id, List<Orderitems> items) {
        this.id = id;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public List<Orderitems> getItems() {
        return items;
    }
    public void  addProduct(Product product){
        Orderitems orderitems1 =new Orderitems(product , 1);
        items.add(orderitems1);
        System.out.println("Added NEW Product..");
    }
    public void getShippingAddress(){

    }

    public double getPrices(){
             return 1.0;
    }
}
