package org.uplift.exam3;

public class Beverage implements Product {
    private String make;
    private long capacity;
    private String flavour;
    private double discount;
    private double price;

    public Beverage(String make, long capacity, String flavour, double discount, double price) {
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
        this.discount = discount;
        this.price = price;
    }

    @Override
    public String getProductDescription() {
        return flavour + " Flavoured beverage " + make + " with " + capacity;
    }

    @Override
    public double getDiscountApplied() {
        return discount;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "make='" + make + '\'' +
                ", capacity=" + capacity +
                ", flavour='" + flavour + '\'' +
                ", discount=" + discount +
                ", price=" + price +
                '}';
    }
}
