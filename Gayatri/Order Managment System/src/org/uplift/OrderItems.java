package org.uplift;

public class OrderItems implements Product {
    private int id;
    private double price;
    private double discountPercentage;
    private int quantity;

    public OrderItems(int id, double price, double discountPercentage, int quantity) {
        this.id = id;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.quantity = quantity;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String getProductDescription() {
        return "Order Item " + id;
    }

    @Override
    public double getDiscountApplied() {
        return price - (price * discountPercentage / 100);
    }

    @Override
    public double netPrice() {
        return getDiscountApplied() * quantity;
    }
}
