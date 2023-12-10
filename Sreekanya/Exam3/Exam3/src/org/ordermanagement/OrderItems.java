package org.ordermanagement;

public class OrderItems {
    private Product product;
    private int quntity;

    public OrderItems(Product product, int quntity) {
        this.product = product;
        this.quntity = quntity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuntity() {
        return quntity;
    }
    public double getPriceOrdeItems(){
        return product.getDiscountApplied()*getQuntity();
    }
}
