package org.Uplift24.Exam3;

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
        double orderItemPrice=(product.getPrice()-product.getDiscountApplied())*quantity;
        return orderItemPrice;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
