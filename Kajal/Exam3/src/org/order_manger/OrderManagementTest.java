package org.order_manger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.orders.Order;
import org.orders.ShippingAddress;
import org.products.Beverage;
import org.products.Book;
import org.products.Product;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagementTest {
    OrderManagement om = null;
    Order o = null;
    Order o1 = null;

    @BeforeEach
    public void startUp(){
        Product p1 = new Book("Book1", "Author1", "Thrilled", 20031, 200.0);
        Product p2 = new Book("Book2", "Author2", "Comedy",786754, 350);
        Product p3 = new Beverage("Tea", 50, "Lemon", 76543, 100.0);
        Product p4 = new Beverage("Shake", 100, "Banana", 87659, 150.0);

        o = new Order(123456);
        o.addProduct(p1);
        o.addProduct(p2);
        o.addProduct(p3);
        o.addProduct(p4);

        o1 = new Order(897643);
        o1.addProduct(p4);
        o1.addProduct(p2);
        o1.addProduct(p1);

        om = new OrderManagement();
        om.addOrders(o);
        //om.addOrders(o1);
    }

    @Test
    public void getOrdersTest(){
        assertTrue(om.getOrders().contains(o));
        assertFalse(om.getOrders().contains(o1));
    }

    @Test
    public void getUniqueShipedCitiesTest(){
        ShippingAddress sa = new ShippingAddress("G-55", "Sangam Vihar", "Delhi", 110090);
        ShippingAddress sa1 = new ShippingAddress("G-55", "Sangam Vihar", "Noida", 110090);

        assertTrue(om.getUniqueShipedCities().contains("Delhi"));
        assertTrue(om.getUniqueShipedCities().contains("Noida"));
        assertFalse(om.getUniqueShipedCities().contains("Chennai"));
    }

}