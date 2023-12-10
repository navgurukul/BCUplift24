package org.uplift;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {
    private  Book b1;
    private Beverage B1;
    private OrderItem o1;
    private OrderItem o2;
    @BeforeEach
    void setupDate(){
        b1=new Book(1,"two states","Chetan Bhagat","fiction",200.);
        B1=new Beverage(20,"Appy",500,"Apple",30.);
        o1=new OrderItem(b1,20);
        o2= new OrderItem(B1,10);

    }

    @Test
    void getPrice() {
        double ans =o1.getPrice();
        assertEquals(3600,ans);

        double ans2 = o2.getPrice();
        assertEquals(240,ans2);

    }
    @AfterEach
    void teatDown(){
        b1=null;
        B1=null;
        o2=null;
        o1=null;
    }
}