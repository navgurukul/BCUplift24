package org.order;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testForToStringOfOrderClass(){
//        Beverage be3=new Beverage("sugar Water",1633,"lemone",120);
//        OrderItem om=new OrderItem(be3,10);
        Order o1=new Order(123);
        assertEquals(123,o1.getId());
    }

    @Test
    void testForOrderitemList(){
        List<OrderItem> orderItemList=new ArrayList<>();
        Beverage be3=new Beverage("sugar Water",1633,"lemone",120);
        Beverage be1=new Beverage("sugar Water",1633,"lemone",20);
        OrderItem om=new OrderItem(be3,10);
        OrderItem om2=new OrderItem(be1,10);
        Order o1=new Order(123);
        orderItemList.add(om);
        orderItemList.add(om2);

        assertTrue(orderItemList.contains(om));
    }

}