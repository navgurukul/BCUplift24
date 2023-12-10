package org.order;

public class Beverage implements Product {
    private String make;
    private long capacity;
    private String flavour;
    private double price;

    public Beverage(String make, long capacity, String flavour,double price) {
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
        this.price=price;
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
        return "the Beverage flavour is  " + flavour +" it make from" + make + "and it capacity is " +capacity;
    }

    @Override
    public double getPrice() {
        return price-getDiscountApplied();
    }

    @Override
    public double getDiscountApplied() {
        return price*0.2;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "make='" + make + '\'' +
                ", capacity=" + capacity +
                ", flavour='" + flavour + '\'' +
                '}';
    }
}
