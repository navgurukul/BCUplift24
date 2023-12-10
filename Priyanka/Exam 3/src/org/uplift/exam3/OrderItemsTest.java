package org.uplift.exam3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemsTest {

    @Test
    void getPrice() {
        Book b1 = new Book("The Immortals of Melhua","Amish","Fiction",10,50);
        OrderItems orderItem1 = new OrderItems(b1,5);
        assertEquals(225,orderItem1.getPrice());
    }

    @Test
    void testToString() {
        Book b1 = new Book("The Immortals of Melhua","Amish","Fiction",10,50);
        OrderItems orderItem1 = new OrderItems(b1,5);
        String result = orderItem1.toString();
        assertTrue(result.contains(b1.toString()));
    }
}