package system.management.order;

import java.util.ArrayList;
import java.util.Set;

public class OrderManagement {
    ArrayList<Order> orders;
    Set<String>UniqueShippedCities;

    public OrderManagement(ArrayList<Order> orders,Set<String>UniqueShippedCities) {
        this.orders = orders;
        this.UniqueShippedCities=UniqueShippedCities;
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }
    public Set<String> getUniqueShippedCities(){
        for(Order order:orders){
            UniqueShippedCities.add(order.getZone());
        }
        return UniqueShippedCities;
    }
}
