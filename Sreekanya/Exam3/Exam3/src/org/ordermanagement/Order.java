package org.ordermanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Order{
    private int quntity;
    private List<Product> items;
    private String city;
    public Order(int quntity,String city){
        this.quntity=quntity;
        this.city=city;
        this.items=new ArrayList<>();
    }
    public String getCity(){
        return city;
    }
    public void addProduct(Product product){
        items.add(product);
        OrderManagement.addOrder(product,getCity());

    }
    public List<Product> getItems(){
        return items;
    }
    public int getQuntity(){
        return quntity;
    }

    public String getShippingAddress(){
        return ShippingAddress.getShippingZone();
    }

    public double getPrice(){
        for(Map.Entry<String,String> map:ShippingAddress.getShippingCities().entrySet()){
            if(map.getValue().equals("East Zone")){
                return 10;
            }
            else if(map.getValue().equals("West Zone")){
                return 5;
            }
            else if(map.getValue().equals("South Zone")){
                return 10;
            }
            else if(map.getValue().equals("North Zone")){
                return 20;
            }

        }return 0;
    }





}
