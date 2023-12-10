package org.orderManagement.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testgetDiscountApplied(){
        Book book1 = new Book(1,"abc","John","XYZJKK",200);
        assertEquals(20,book1.getDiscountApplied());
    }

    @Test
    void testnetPrice(){
        Book book1 = new Book(1,"abc","John","XYZJKK",200);
        assertEquals(180,book1.netPrice());
    }

}