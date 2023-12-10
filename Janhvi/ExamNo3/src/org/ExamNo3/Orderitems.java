package org.ExamNo3;

public class Orderitems {
    private Product product;
    private int quantity;

    public Orderitems(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getPrice(Product p){
        return p.netPrice();
    }
}
