package org.OrderManagementSystem;

public class OrderItems {
    private Product product;
    private int quantity;


    public OrderItems(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }


    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice(){
        double i = getPrice()-(product.getPrice()- product.getDiscountPercentage()*getQuantity());
        return i;

    }
}
