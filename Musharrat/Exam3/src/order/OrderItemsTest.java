package order;

import order.products.Book;
import order.products.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemsTest {

    @Test
    void testGetPrice() {
        Product product1 = new Book(1, 500.0, "1921", "Stephen King","Horror");
        OrderItems ot = new OrderItems(product1, 2);

        assertEquals(900, ot.getPrice());
    }
}