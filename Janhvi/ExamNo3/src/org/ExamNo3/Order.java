package org.ExamNo3;

import java.util.List;
import java.util.Map;

public class Order {
    private int id;
    private List<Orderitems> items;
    private Map<String,Double> zoneShippingCharges;

    public Order(int id) {
        this.id = id;
        this.items = items;
        this.zoneShippingCharges = zoneShippingCharges;
    }

    public int getId() {
        return id;
    }

    public List<Orderitems> getItems() {
        return items;
    }
//    public void addProductFromOrderitems(Orderitems om){
//        getItems().add(om);
//
//    }
    public ShippingAddress getShippingAddress(ShippingAddress s) {
        //String address = String.valueOf(new ShippingAddress("ABC Zone Chennai","ABC Zone","Chennai",444101,"SouthZone"));
        //return address;
        return s;

    }
    public double calculateDistance(){
       return Math.random();
    }
    public double calculateShippingCharges(){
        return calculateDistance()*40;
    }
    public double getPrice(Product product){
        return product.netPrice()+calculateShippingCharges();

    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                ", zoneShippingCharges=" + zoneShippingCharges +
                '}';
    }
}
