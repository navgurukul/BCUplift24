package org.OrderManagementSystem;

public class ProductClass {
    private int id;
    private double price;
    private double discountPercentage;

    public ProductClass(int id, double price) {
        this.id = id;
        this.price = price;
        this.discountPercentage = 0;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public String toString() {
        return "ProductClass{" +
                "id=" + id +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
