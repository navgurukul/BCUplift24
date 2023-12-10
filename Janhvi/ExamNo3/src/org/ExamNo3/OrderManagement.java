package org.ExamNo3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderManagement {


    List<Order> orders =new ArrayList<>();
    public List<Order> getOrders() {
        return orders;
    }
    Set<String> getUniqueShippedCities = new HashSet<>();

    public Set<String> getGetUniqueShippedCities() {
        return getUniqueShippedCities;
    }
    public void addOrder(Order o){
        orders.add(o);
    }

}
