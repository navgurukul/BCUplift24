package org.uplift.exam3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addOrderItems() {
        Book b1 = new Book("The Immortals of Melhua","Amish","Fiction",10,50);
        OrderItems orderItem1 = new OrderItems(b1,5);
        ShippingAddress sd1 = new ShippingAddress("xyz","yyy","Chennai",1234567);
        sd1.addtoMap();
        Order o1 = new Order(12345,orderItem1,sd1);
        o1.addOrderItems(orderItem1);
        assertEquals(o1.items.size(),1);
    }

    @Test
    void getPrice() {
        Book b1 = new Book("The Immortals of Melhua","Amish","Fiction",10,50);
        OrderItems orderItem1 = new OrderItems(b1,5);
        ShippingAddress sd1 = new ShippingAddress("xyz","yyy","Chennai",1234567);
        sd1.addtoMap();
        Order o1 = new Order(12345,orderItem1,sd1);
        assertEquals(275,o1.getPrice());
    }

    @Test
    void testToString() {
        Book b1 = new Book("The Immortals of Melhua","Amish","Fiction",10,50);
        OrderItems orderItem1 = new OrderItems(b1,5);
        ShippingAddress sd1 = new ShippingAddress("xyz","yyy","Chennai",1234567);
        Order o1 = new Order(12345,orderItem1,sd1);
        String result = o1.toString();
        assertTrue(result.contains("12345"));
        assertTrue(result.contains(orderItem1.toString()));
        assertTrue(result.contains(sd1.toString()));

    }
}