package order;

import order.products.Beverage;
import order.products.Book;
import order.products.Product;
import order.shippingaddress.ShippingAddress;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    public static Order order;
    public static ShippingAddress shippingAddress;

    public static Product book;
    public static Product beverage;

    @BeforeEach
    void setUp() {
        shippingAddress = new ShippingAddress("NavGurukul " +
                "Sarjapur Campus", "HalnayakanHalli", "Bangalore", 110062);
        order = new Order(873295, shippingAddress);
        book = new Book(1, 500.0, "1921", "Stephen King", "Horror");
        beverage = new Beverage(1, 100, "CafeCoffeeDay", 50, "cold coffee");
    }

    @AfterEach
    void tearDown() {
        shippingAddress = null;
        order = null;
    }


    @Test
    void testGetPrice() {

        order.addProduct(book, 2);
        order.addProduct(beverage, 1);

        assertEquals(1180, order.getPrice());

    }
}