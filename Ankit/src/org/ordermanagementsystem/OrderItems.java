package org.ordermanagementsystem;

public class OrderItems {
    private Product product ;
    private int quantity;

    public OrderItems(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getPrice(){
        return (product.getPrice() - product.getDiscountApplied()) * quantity;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
