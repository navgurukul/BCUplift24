package org.ExamNo3;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @org.junit.jupiter.api.Test
    void getProductDescription() {
        Book book = new Book(1,500,0.2,"Wings of fire","Apj Abdul kalam","Motivation");
        String result = book.getProductDescription();
        assertTrue(result.contains("Wings of fire"));
    }

    @org.junit.jupiter.api.Test
    void getDiscountApplied() {
        Book book = new Book(1,500,0.2,"Wings of fire","Apj Abdul kalam","Motivation");
        double result = book.getDiscountApplied();
        assertEquals(400.0,result);

    }

    @org.junit.jupiter.api.Test
    void netPrice() {
        Book book = new Book(1,500,0.2,"Wings of fire","Apj Abdul kalam","Motivation");
        assertEquals(400.0,book.netPrice());
    }
}