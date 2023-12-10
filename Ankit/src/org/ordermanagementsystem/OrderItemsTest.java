package org.ordermanagementsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemsTest {

    @Test
    void getPrice() {
        Beverage b1 = new Beverage(1,200,20,"nimbu",500L,"paperBoat");
        OrderItems orderItems = new OrderItems(b1,2);
        double price = orderItems.getPrice();
        assertEquals(320,price);
    }

    @Test
    void testToString() {
        Beverage b1 = new Beverage(1,200,20,"nimbu",500L,"paperBoat");
        OrderItems orderItems = new OrderItems(b1,2);
        String str = orderItems.toString();
        assertTrue(str.contains(b1.getMake()));
    }
}