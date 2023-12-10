package org.uplift;

public class Beverage implements Product {
    private int id;
    private double price;
    private double discountPercentage;
    private String make;
    private long capacity;
    private String flavour;

    public Beverage(int id, double price, double discountPercentage, String make, long capacity, String flavour) {
        this.id = id;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
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

    @Override
    public String getProductDescription() {
        return flavour + " flavored beverage, make: " + make + ", capacity: " + capacity;
    }

    @Override
    public double getDiscountApplied() {
        return price - (price * discountPercentage / 100);
    }

    @Override
    public double netPrice() {
        return getDiscountApplied();
    }
}

