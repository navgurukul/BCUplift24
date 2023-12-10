package org.orderManagement.orderdetails;

import org.orderManagement.product.Product;

public class OderIterms {
    private Product product;
    private int quantity;

    public OderIterms(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getPrice() {
        return (product.getPrice() - product.getDiscountApplied())*quantity;
    }

}
