package org.orders;

import org.products.Product;

public class OrderItems {
    private Product product;
    private int quantity;
    public OrderItems(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public double getPrice(){
        return (product.netPrice()-product.getDiscountApplied())*quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
