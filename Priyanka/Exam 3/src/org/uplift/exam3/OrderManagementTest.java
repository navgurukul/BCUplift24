package org.uplift.exam3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagementTest {

    @Test
    void addOrder() {
        Book b1 = new Book("The Immortals of Melhua","Amish","Fiction",10,50);
        OrderItems orderItem1 = new OrderItems(b1,5);
        ShippingAddress sd1 = new ShippingAddress("xyz","yyy","Chennai",1234567);
        Order o1 = new Order(12345,orderItem1,sd1);
        OrderManagement om = new OrderManagement();
        om.addOrder(o1);
        assertEquals(om.orders.size(),1);
    }

    @Test
    void getUniqueShippedCities() {
        Book b1 = new Book("The Immortals of Melhua","Amish","Fiction",10,50);
        Book b2 = new Book("The Immortals","Mit","Fictions",10,30);

        OrderItems orderItem1 = new OrderItems(b1,5);
        OrderItems orderItem2 = new OrderItems(b2,5);

        ShippingAddress sd1 = new ShippingAddress("xyz","yyy","Chennai",1234567);
        ShippingAddress sd2 = new ShippingAddress("tyu","zzz","Chennai",1234567);

        Order o1 = new Order(12345,orderItem1,sd1);
        Order o2 = new Order(2345,orderItem2,sd2);

        OrderManagement om = new OrderManagement();
        om.addOrder(o1);
        om.addOrder(o2);

        om.getUniqueShippedCities();
        assertEquals(om.uniqueShippingCities.size(),1);
    }
}