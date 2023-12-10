package org.OrderManagementSystem;

import org.junit.jupiter.api.Test;

import static java.awt.PageAttributes.MediaType.B1;
import static org.junit.jupiter.api.Assertions.*;

class OrderItemsTest {
    Beverage B1 = new Beverage(1000,"Mango");
    OrderItems i1 = new OrderItems(B1,3);

    @Test
    void getQuantity() {
        assertEquals(3,i1.getQuantity());

    }

    @Test
    void getPrice() {
    }
}