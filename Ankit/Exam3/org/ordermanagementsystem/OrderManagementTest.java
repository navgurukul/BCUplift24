package org.ordermanagementsystem;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagementTest {

    @Test
    void getOrders() {
        Beverage beverege1 = new Beverage(1,200,20,"nimbu",500,"paperBoat");
        OrderItems orderItems1 = new OrderItems(beverege1,1);
        Order first = new Order(1L);
        first.addProduct(orderItems1);

        List<Order> orders = List.of(first);

        OrderManagement orderManagement = new OrderManagement(orders);
        List<Order> list = orderManagement.getOrders();
        assertFalse(list.isEmpty());
    }
}