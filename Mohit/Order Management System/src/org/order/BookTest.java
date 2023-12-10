package org.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void testForToString() {
        Book b1 = new Book("one", "ram Das", "Todo",200);

        assertEquals("one", b1.getTitle());

    }
    @Test

    void testForDiscountApplied(){
        Book b1 = new Book("one", "ram Das", "Todo",200);
        assertEquals(20.0,b1.getDiscountApplied());
    }
    @Test

    void testForPrice(){
        Book b1 = new Book("one", "ram Das", "Todo",200);
        assertEquals(180.0,b1.getPrice());
    }





}