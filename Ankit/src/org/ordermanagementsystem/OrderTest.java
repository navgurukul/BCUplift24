package org.ordermanagementsystem;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addProduct() {
        Book b1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        OrderItems orderItems = new OrderItems(b1,1);
        Order order = new Order(1L);
        order.addProduct(orderItems);
        assertFalse(order.items.isEmpty());

    }

    @Test
    void getItems() {
        Book b1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        OrderItems orderItems = new OrderItems(b1,1);
        Order order = new Order(1L);
        order.addProduct(orderItems);
        List<OrderItems> list = order.getItems() ;
        assertTrue(list.contains(orderItems));
    }

}