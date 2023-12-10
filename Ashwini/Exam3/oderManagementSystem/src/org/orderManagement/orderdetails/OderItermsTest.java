package org.orderManagement.orderdetails;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.orderManagement.product.Book;
import org.orderManagement.product.Product;

import static org.junit.jupiter.api.Assertions.*;

class OderItermsTest {
    @Test
    void testgetPrice(){
        Book book1 = new Book(1, "abc", "John", "XYZJKK", 200);
        int quantity =5;
        OderIterms orderitem= new OderIterms(book1,quantity);

        assertEquals(900,orderitem.getPrice());
    }

}