package org.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {
    @Test
    void testForOrderItemsToString(){
        Beverage be3=new Beverage("sugar Water",1633,"lemone",120);
        OrderItem om=new OrderItem(be3,10);
        assertEquals(10,om.getQuantity());

    }
    @Test
    void testForOrderItemPrice(){
        Beverage be3=new Beverage("sugar Water",1633,"lemone",120);
        OrderItem om=new OrderItem(be3,10);
        double orderItemPrice=om.getProduct().getPrice() *om.getQuantity();
        assertEquals(960,orderItemPrice);
    }


}