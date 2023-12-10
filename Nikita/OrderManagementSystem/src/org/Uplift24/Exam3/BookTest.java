package org.Uplift24.Exam3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book b1=null;
    private Book b2=null;

    @BeforeEach
    void setUpData(){
        b1=new Book("Mrutyunjay","Shivaji savant","NonFiction",900);
        b2=new Book("Mahashweta","Sudha Murti","NonFiction",700);
    }
    @AfterEach
    void  tearDown(){
        b1=null;
        b2=null;
    }
    @Test
    void testGetDiscountApplied(){
        assertEquals(90,b1.getDiscountApplied());
    }

    @Test
    void testToString(){
        String result=b1.toString();
        assertTrue(result.contains("Mrutyunjay"));
        assertTrue(result.contains("Shivaji savant"));
        assertTrue(result.contains("NonFiction"));
        assertTrue(result.contains(Integer.toString(900)));

    }
}