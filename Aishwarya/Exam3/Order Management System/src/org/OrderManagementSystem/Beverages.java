package org.OrderManagementSystem;

public class Beverages implements Product{

    private String make;
    private long capacity;
    private String flavour;
    private double price;

    public Beverages(String make, long capacity, String flavour, double price) {
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
        this.price = price;
    }

    @Override
    public String getProductDescription() {
        return "Beverage it is " + flavour + " flavoured " + make + " with capacity " + capacity;
    }

    @Override
    public double getDiscountApplied() {

        double percentage =  Product.discountPercentage + 0.1;
        double discountPrice = price * percentage;
        return discountPrice;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Beverages{" +
                "make='" + make + '\'' +
                ", capacity=" + capacity +
                ", flavour='" + flavour + '\'' +
                ", price=" + price +
                '}';
    }
}
