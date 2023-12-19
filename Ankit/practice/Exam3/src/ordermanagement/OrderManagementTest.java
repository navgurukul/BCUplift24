package ordermanagement;

import ordermanagement.exception.OutOfStockException;
import org.junit.jupiter.api.Test;
import ordermanagement.order.Order;
import ordermanagement.order.OrderItems;
import ordermanagement.product.Beverage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagementTest {

    @Test
    void getOrders() throws OutOfStockException {
        Beverage beverege1 = new Beverage(1,200,20,"nimbu",500,"paperBoat");
        ShippingAddress customer1 = new ShippingAddress("h.no 37","sarjapur","Bangluru",12L, ShippingAddress.SOUTH);
        Order first = new Order(1L,customer1);
        first.addProduct(beverege1,3);

        OrderManagement orderManagement = new OrderManagement();
        List<Order> list = orderManagement.getOrders();
        assertFalse(list.isEmpty());
    }
}