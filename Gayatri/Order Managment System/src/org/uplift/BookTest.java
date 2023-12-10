package org.uplift;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {
    private Book b1;
    @BeforeEach
    void setUpData(){
         b1= new Book(1,200.0,10.0,"Jivan","Gaur gopal das","Motivational");
    }

    @org.junit.jupiter.api.Test
    void getProductDescription() {
        b1.getProductDescription();
        assertTrue(b1.getProductDescription().contains("genre"));
    }

    @org.junit.jupiter.api.Test
    void getDiscountApplied() {
        double a = b1.getPrice() -( b1.getPrice() * b1.getDiscountPercentage() / 100);
        System.out.println(a);
    }


    @org.junit.jupiter.api.Test
    void netPrice() {
      assertEquals(180.0,b1.getDiscountApplied());
    }
}