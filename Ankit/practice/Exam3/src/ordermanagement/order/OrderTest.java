package ordermanagement.order;

import ordermanagement.ShippingAddress;
import ordermanagement.exception.OutOfStockException;
import ordermanagement.product.Product;
import org.junit.jupiter.api.Test;
import ordermanagement.product.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addProduct() throws OutOfStockException {
        Book b1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        Book b2 = new Book(1,500,10,"habits","James clear","Self helped");
        ShippingAddress customer1 = new ShippingAddress("h.no 37","sarjapur","Bangluru",12L, ShippingAddress.SOUTH);
        Order order = new Order(1L,customer1);
        order.addProductToInventory(b1, 5);
        order.addProduct(b1,3);
        assertFalse(order.getItems().isEmpty());
        assertThrows(OutOfStockException.class,()-> order.addProduct(b2,12));

    }

    @Test
    void getItems() throws OutOfStockException {
        Book b1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        OrderItems orderItems = new OrderItems(b1,3);
        ShippingAddress customer1 = new ShippingAddress("h.no 37","sarjapur","Bangluru",12L, ShippingAddress.SOUTH);
        Order order = new Order(1L,customer1);
        order.addProductToInventory(b1,5);
        order.addProduct(b1,3);
        List<OrderItems> list = order.getItems() ;
        assertTrue(list.contains(orderItems));
    }

}