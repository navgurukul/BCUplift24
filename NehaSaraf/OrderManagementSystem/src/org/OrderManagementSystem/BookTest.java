package org.OrderManagementSystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book b1=null;

    @BeforeEach
    void setUp(){
        b1=new Book(222,1000,"The Immortals of Melhua","Amish","Diction");
    }
    @AfterEach
    void tearDown(){
        b1=null;
    }
    @Test
    void testGetProductDescription() {
        String s=b1.getProductDescription();
        assertTrue(s.contains("Amish"));
        assertTrue(s.contains("The Immortals of Melhua"));

    }

    @Test
    void testToString() {
        String result=b1.toString();
        assertTrue(result.contains("Amish"));
        assertTrue(result.contains("The Immortals of Melhua"));
        assertTrue(result.contains("Diction"));
    }
}