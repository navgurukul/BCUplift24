package org.uplift.ordermanagement;

public class Beverage implements Product {
    private String make;
    private long capacity;
    private String flavour;
    private double price;

    @Override
    public double getDiscountApplied() {
        return 0.20*price;
    }

    @Override
    public double netPrice() {
        return price;
    }

    public Beverage(String make, long capacity, String flavour, double price) {
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public long getCapacity() {
        return capacity;
    }

    public String getFlavour() {
        return flavour;
    }

    @Override
    public String getProductDescription() {
        return "Beverage{" +
                "make='" + make + '\'' +
                ", capacity=" + capacity +
                ", flavour='" + flavour + '\'' +
                ", price=" + price +
                '}';
    }
}
