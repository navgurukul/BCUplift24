package org.Uplift24.Exam3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class OrderManagement {
    private ArrayList<Order> orders=new ArrayList<>();
    private Set<Order> orderSet=new TreeSet<>();


    public void addOrders(Order o){
        orders.add(o);
    }
    public void getOrders(Order o){
        if(orders.contains(o)){
            orders.remove(o);
        }
        else{
            System.out.println("This order is not in list. Sorry!");
        }
    }
    public  Set<Order> getUniqueShippedCities(){
        return new TreeSet<>(orders);
    }

    @Override
    public String toString() {
        return "OrderManagement{" +
                "orders=" + orders +
                ", orderSet=" + orderSet +
                '}';
    }
}
