package org.ordermanagementsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void getProductDescription() {
        Book b1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        String output = b1.getProductDescription();
        assertTrue(output.contains(b1.getTitle()));
    }

    @Test
    void getDiscountApplied() {
        Book b1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        double discount = b1.getDiscountApplied();
        assertEquals(50,discount);
    }

    @Test
    void getPrice() {
        Book b1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        double price = b1.getPrice();
        assertEquals(b1.price,price);
    }

    @Test
    void netPrice() {
        Book b1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        double netPrice = b1.netPrice();
        assertEquals(450,netPrice);
    }

    @Test
    void testToString() {
        Book b1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        String str = b1.toString();
        assertTrue(str.contains(b1.getAuthor()));
    }
}