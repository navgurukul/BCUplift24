package org.uplift.ordermanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.util.SortedSet;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagementTest {

    private OrderManagement orderManagement;

    @BeforeEach
    public void setUp() {
        orderManagement = new OrderManagement();
    }
    @Test
    public void testPlaceOrderAndCalculateCost() {
        // Given
        Order order = new Order(); // Create an Order with products, shipping address, etc.

        // When
        orderManagement.placeOrder(order);

        // Then
        double calculatedCost = order.calculateOrderCost();
        assertEquals(calculatedCost, orderManagement.calculateTotalOrderCost(order));
    }

    @org.junit.jupiter.api.Test
    public void testPrintUniqueShippedCities() {

        Order order1 = new Order();
        order1.setShippingAddress("Chennai");

        Order order2 = new Order();
        order2.setShippingAddress("Bangalore");

        OrderManagement orderManagement = null;
        orderManagement.placeOrder(order1);
        orderManagement.placeOrder(order2);

        orderManagement.printUniqueShippedCities();
    }
}