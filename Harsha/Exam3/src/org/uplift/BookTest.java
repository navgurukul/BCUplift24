package org.uplift;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book b1;
    @BeforeEach
    void setupData(){
        b1= new Book(2,"Dogalapan","Ashnir Grover","Motivational",300.);
    }



    @org.junit.jupiter.api.Test
    void getDiscountApplied() {
        double ans=b1.getDiscountApplied();
        assertEquals(30,ans);
    }
    @org.junit.jupiter.api.Test
    void netPrice() {
        double ans=b1.netPrice();
        assertEquals(270,ans);

    }

    @Test
    void getProductDescription(){
        String ans= b1.getProductDescription();
        assertTrue(ans.contains("Motivational"));
    }
    @AfterEach
    void tearDown(){
        b1=null;
    }
}