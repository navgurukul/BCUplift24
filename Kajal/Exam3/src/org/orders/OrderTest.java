package org.orders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.products.Beverage;
import org.products.Book;
import org.products.Product;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Product p1 = null;
    Product p2 = null;
    Product p3 = null;
    Product p4 = null;
    Order o = null;


    @BeforeEach
    public void startUp(){
        p1 = new Book("Book1", "Author1", "Thrilled", 20031, 200.0);
        p2 = new Book("Book2", "Author2", "Comedy",786754, 350.0);
        p3 = new Beverage("Tea", 50, "Lemon", 76543, 100.0);
        p4 = new Beverage("Shake", 100, "Banana", 87659, 150.0);

        o = new Order(123456);
        o.addProduct(p1);
        o.addProduct(p2);
        o.addProduct(p3);
        o.addProduct(p4);
    }

    @Test
    public void getItemsTest(){
        Product p = o.getItems().get(0).getProduct();
        assertTrue(p1.equals(p));
    }

    @Test
    public void getPriceTest(){
        ShippingAddress sa = new ShippingAddress("G-55", "Sangam Vihar", "Delhi", 110090);
        o.getShippingAddress(sa);
        assertEquals(725.0, o.getPrice());
    }

}