package org.uplift.ordermanagementsystem;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem: " +"\n"+
                "product= " + product +
                "quantity= " + quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return product.getPrice();
    }
    public double getTotalPrice(){
        return (product.getPrice() - (product.getPrice() * product.getDiscountPercentage() / 100)) * quantity;
    }
}
