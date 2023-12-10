package orderManagement;

import order.Order;
import order.products.Beverage;
import order.products.Book;
import order.products.Product;
import order.shippingaddress.ShippingAddress;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagementTest {
    OrderManagement om;
    ShippingAddress shippingAddress;
    ShippingAddress shippingAddress2;
    Order order1;
    Order order2;

    @BeforeEach
    public void setUp(){
        om = new OrderManagement();

        shippingAddress = new ShippingAddress("NavGurukul " +
                "Sarjapur Campus", "HalnayakanHalli", "Bangalore", 110062);

        shippingAddress2 = new ShippingAddress("NavGurukul " +
                "Delhi Campus", "Dwarka", "Delhi", 110062);

        order1 =new Order(11111, shippingAddress);
        Product book = new Book(1, 500.0, "1921", "Stephen King", "Horror");
        Product beverage = new Beverage(1, 100, "CafeCoffeeDay", 50, "cold coffee");
        order1.addProduct(book, 2);
        order1.addProduct(beverage, 1);

        order2 = new Order(22222, shippingAddress2);
        order2.addProduct(book, 2);
        order1.addProduct(beverage, 1);
    }

    @AfterEach
    public void tearDown(){
        om = null;
        shippingAddress = null;
        shippingAddress2 = null;
        order1 = null;
        order2 = null;
    }

    @Test
    void testPlaceOrder() {
        om.placeOrder(order1);
        om.placeOrder(order2);

        assertTrue(om.orders.contains(order1));
        assertTrue(om.orders.contains(order2));
    }

    @Test
    void testGetUniqueShippedCities() {

        om.placeOrder(order1);
        om.placeOrder(order2);

        assertTrue(om.uniqueShippedCities.contains("Delhi"));
        assertTrue(om.uniqueShippedCities.contains("Bangalore"));
        assertFalse(om.uniqueShippedCities.contains("Tripura"));
    }
}