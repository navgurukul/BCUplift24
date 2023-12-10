package org.uplift.ordermanagement;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Product p=new Book("ABC","CDE","PQR",100);
    @Test
    void getDiscountApplied() {
        double discount=10;
        assertEquals(10,p.getDiscountApplied());
    }

    @org.junit.jupiter.api.Test
    void testOfProductDescription() {
        String str=p.getProductDescription();
        assertTrue(str.contains("ABC"));
        assertTrue(str.contains("CDE"));
        assertTrue(str.contains("PQR"));
        assertTrue(str.contains("100"));
    }
}