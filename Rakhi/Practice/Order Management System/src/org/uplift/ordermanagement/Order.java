package org.uplift.ordermanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private String orderId;
    private ShippingAddress shippingAddress;

    private ArrayList<OrderItems> items=new ArrayList<>();

    public ArrayList<Product> productList=new ArrayList<>();

    public Order(String orderId, ArrayList<OrderItems> ordItem,ShippingAddress shippingAddress) {
        this.orderId = orderId;
        this.items=ordItem;
        this.shippingAddress = shippingAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public Map<String, Double> getZoneShipppingCharge() {
        return zoneShipppingCharge;
    }

    public ShippingAddress getShippingAddress(){
        return shippingAddress;
    }
    public void addProduct(Product p){
        productList.add(p);
    }


    public ArrayList<OrderItems> getItems() {
        return items;
    }

    public double getprice(){
        double sumOfAllItemPrice=0.0;
        for(OrderItems o: items){
            sumOfAllItemPrice+=o.getPrice();
        }
        double shippingCharge=zoneShipppingCharge.get(shippingAddress.getZone());
        return sumOfAllItemPrice+shippingCharge;
    }
    Map<String,Double> zoneShipppingCharge=new HashMap<>();
    public void createZoneShippingCharge(){
        zoneShipppingCharge.put("N",200.0);
        zoneShipppingCharge.put("S",300.0);
        zoneShipppingCharge.put("E",100.0);
        zoneShipppingCharge.put("W",150.0);
    }

    public void addOrderItems(OrderItems ordItem){
        items.add(ordItem);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", shippingAddress=" + shippingAddress +
                ", items=" + items +
                ", productList=" + productList +
                ", zoneShipppingCharge=" + zoneShipppingCharge +
                '}';
    }
}
