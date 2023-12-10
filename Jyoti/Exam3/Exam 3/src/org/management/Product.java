package org.management;
public class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected String description;
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public double calculateCost(double discount, double shippingCost) {
        return (price - discount) * quantity + shippingCost;
    }
    public String getDescription() {
        return String.valueOf(description);
    }

}
