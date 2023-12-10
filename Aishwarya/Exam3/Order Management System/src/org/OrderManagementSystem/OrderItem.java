package org.OrderManagementSystem;

import static org.OrderManagementSystem.Product.discountPercentage;
import static org.OrderManagementSystem.Product.price;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getPrice(){
        double oderItemPrice = (product.getPrice() - product.getDiscountApplied()) * quantity;

        return oderItemPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
