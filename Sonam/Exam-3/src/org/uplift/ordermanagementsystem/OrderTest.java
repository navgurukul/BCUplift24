package org.uplift.ordermanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Book book1;
    Book book2;
    OrderItem orderItem1;
    OrderItem orderItem2;
    ShippingAddress s1;
    ShippingAddress s2;

    @BeforeEach
    public void makeObjects(){
        book1 = new Book(1, 30.0, 10.0, "The Immortals of Melhua", "Amish", "Fiction");
        book2 = new Book(1, 20.0, 10.0, "The  of Melhua", "Sonam", "koliya");

        OrderItem orderItem1 = new OrderItem(book1, 2);
        OrderItem orderItem2 = new OrderItem(book2, 1);
        s1 = new ShippingAddress("123 Main St", "Downtown", "Chennai", 600001, "South");
        s2 = new ShippingAddress("456 Oak St", "Suburb", "Mumbai", 400001, "West");
    }
    @Test
    public void testGetPrice() {
        Order order1 = new Order(1, s1);
        Order order2 = new Order(2, s2);
        order1.getItems().add(orderItem1);
        order2.getItems().add(orderItem2);
        assertEquals(30.0, order1.getPrice());
        assertEquals(20.0, order2.getPrice());
    }
    @Test
    public void testGetTotalPrice(){
        Order order = new Order(1, s1);
        OrderItem orderItem = new OrderItem(book1, 2);
        order.getItems().add(orderItem);
        assertEquals(54.0, orderItem.getTotalPrice());

    }
}