package org.orderManagement.orderdetails;

import org.junit.jupiter.api.Test;
import org.orderManagement.product.Beverage;
import org.orderManagement.product.Book;
import org.orderManagement.product.Product;
import org.orderManagement.zone.ShippingAddress;
import org.orderManagement.zone.Zone;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testgetPrice(){
        Order order1 = new Order(12,new ShippingAddress("abc","bcd","Mumbai",9876L, Zone.WEST));
        Book book1 = new Book(1,"abc","John","XYZJKK",200);
        Beverage beverage1 = new Beverage(12,"abc","hhjuyhn",98766544L,300);

        OderIterms ite1 = new OderIterms(book1,5);
        OderIterms ite2 = new OderIterms(beverage1,2);
        order1.addProduct(ite1 );
        order1.addProduct(ite2);

        assertEquals(1380,order1.getprice());
    }

}