package org.OrderManagementSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testToString() {
        Book b2=new Book(111,500,"Java Book","Abc","xyz");
        ShippingAddress address=new ShippingAddress("aaaaaaaaaaaa","bbbbbbbbbb","Mumbai",111111);
        OrderItems ot1=new OrderItems(b2,10);
        Order order=new Order(12345,address);
        String s=order.toString();
        assertTrue(s.contains("aaaaaaaaaaaa"));
        assertTrue(s.contains("12345"));
        assertTrue(s.contains("Mumbai"));
    }
}