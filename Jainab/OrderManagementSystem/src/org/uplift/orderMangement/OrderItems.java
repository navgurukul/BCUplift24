package org.uplift.orderMangement;

public class OrderItems extends Order{
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

    public  double getPrice(){

        return 0;
    }
}
