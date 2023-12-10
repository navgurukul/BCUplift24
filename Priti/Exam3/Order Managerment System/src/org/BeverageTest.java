package org;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
     void getDiscountApplied(){
        Product p1 = new Beverage(105,1000.0,"make2",10L,"choclate");

        List<Orderitems> orderitemsList = new ArrayList<>();
        orderitemsList.add(new Orderitems(p1,1));
        Order order1 =  new Order((long) 10135456.0,orderitemsList);
        assertEquals(100,order1.getItems().get(0).getPrice());

    }
    void getPrice(){
         Product p1 = new Beverage(105,1000.0,"make2",10L,"choclate");
         List<Orderitems> orderitemsList = new ArrayList<>();
         orderitemsList.add(new Orderitems(p1,1));
         Order order1 =  new Order((long) 10135456.0,orderitemsList);
         assertEquals(100,order1.getItems().get(0).getPrice());
    }

}