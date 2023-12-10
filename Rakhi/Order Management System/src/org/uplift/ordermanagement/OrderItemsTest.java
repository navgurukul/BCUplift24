package org.uplift.ordermanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemsTest {
    Product p=new Book("ABC","CDE","PQR",100);
    OrderItems orderItems=new OrderItems(p,2);


    @Test
    void getPrice() {
        assertEquals(180,orderItems.getPrice());
    }
}