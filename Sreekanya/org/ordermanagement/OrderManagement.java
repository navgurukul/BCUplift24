package org.ordermanagement;

import java.util.*;

public class OrderManagement {
    static Map<Product, String> orderList;
    Set<String> unicOrderCities;
    public OrderManagement(){
        this.orderList=new HashMap<Product, String>();
        this.unicOrderCities=new HashSet<>();
    }

    public Map<Product, String> getOrderList(){
        return orderList;
    }

    public static void addOrder(Product product, String city){
        orderList.put(product,city);
    }

    public Set<String> displayunicordercities(){
        for(Map.Entry<Product, String> map:getOrderList().entrySet()){
            unicOrderCities.add(map.getValue());
            System.out.println(map);
        }
        return unicOrderCities;
    }
}
