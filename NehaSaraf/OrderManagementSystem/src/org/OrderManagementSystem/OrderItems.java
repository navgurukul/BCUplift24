package org.OrderManagementSystem;

public class OrderItems {
    private ProductClass product;
    private int quantity;

    public OrderItems(ProductClass product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getPrice(){
        double orderItemPrice=(product.getPrice()-product.getDiscountPercentage())*quantity;
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
