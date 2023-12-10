package org.products;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.orders.Order;

class BookTest {
    public Product p1 = null;
    public Product p2 = null;

    @BeforeEach
    public void startUp(){
        p1 = new Book("Book1", "Author1", "Thrilled", 20031, 200.0);
        p2 = new Book("Book2", "Author2", "Comedy",786754, 350);

    }
    @Test
    public void getProductDescriptionTest(){
        String result = p1.getProductDescription();
        assertTrue(result.contains("Book1"));
    }

    @Test
    public void getDiscountAppliedTest(){
        assertEquals(20, p1.getDiscountApplied());
    }

    @Test
    public void netPriceTest(){
        assertEquals(200,p1.netPrice());
    }
}