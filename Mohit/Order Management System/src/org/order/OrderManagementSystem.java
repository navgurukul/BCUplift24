package org.order;

import java.util.ArrayList;
import java.util.List;

public class OrderManagementSystem {
    private List<Order> orderList=new ArrayList<>();

    public List<Order> getOrderList() {
        return orderList;
    }
    public void addOrder(Order order){
        orderList.add(order);
    }

//    @Override
//    public String toString() {
//        return "OrderManagementSystem{" +
//                "orderList=" + orderList +
//                '}';
//    }
}
