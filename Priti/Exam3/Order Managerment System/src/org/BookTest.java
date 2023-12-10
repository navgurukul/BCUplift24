package org;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    void getDiscountApplied(){
        Product p1 = new Book(105,1000.0,"Book1","Rajesh Khanna","genere1");

        List<Orderitems> orderitemsList = new ArrayList<>();
        orderitemsList.add(new Orderitems(p1,1));
        Order order1 =  new Order((long) 10135456.0,orderitemsList);
        assertEquals(100,order1.getItems().get(0).getPrice());

    }
    void getPrice(){
        Product p1 = new Book(105,1000.0,"make2","Rajesh Khanna","genere2");
        List<Orderitems> orderitemsList = new ArrayList<>();
        orderitemsList.add(new Orderitems(p1,1));
        Order order1 =  new Order((long) 10135456.0,orderitemsList);
        assertEquals(100,order1.getItems().get(0).getPrice());
    }

}