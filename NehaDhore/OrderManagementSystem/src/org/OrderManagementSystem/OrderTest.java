package org.OrderManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Order O = new Order(1);
    Beverage B1 = new Beverage(1000,"Mango");

    @org.junit.jupiter.api.Test
    boolean addProduct() {
        assertFalse(O.getItems().isEmpty(), O.addProduct(B1));

        return false;
    }

    @org.junit.jupiter.api.Test
    void getId() {
        assertEquals('1',O.getId());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {

    }

    @org.junit.jupiter.api.Test
    void getShippingAddress() {
    }

    @org.junit.jupiter.api.Test
    void getItems() {
    }

    @org.junit.jupiter.api.Test
    void getProductSet() {
    }
}