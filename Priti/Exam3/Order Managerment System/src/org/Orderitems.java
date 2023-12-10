package org;

public class Orderitems {
    private Product product;
    private  int quantity;
    public double getPrices(){
        return product.getPrice();
    }

    public Product getProduct(){
        return product;
    }
    public Orderitems(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return product.getPrice();
    }
}
