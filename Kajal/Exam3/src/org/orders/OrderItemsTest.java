package org.orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.products.Beverage;
import org.products.Book;
import org.products.Product;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemsTest {
    Product p1 = null;
    Product p3 = null;

    @BeforeEach
    public void startUp(){
        p1 = new Book("Book1", "Author1", "Thrilled", 20031, 200.0);
        p3 = new Beverage("Tea", 50, "Lemon", 76543, 100.0);
    }

    @Test
    public void getPriceTest(){
        OrderItems oi = new OrderItems(p1, 1);
        OrderItems oi1 = new OrderItems(p3, 2);

        assertEquals(180, oi.getPrice());
        assertEquals(160, oi1.getPrice());
    }

}