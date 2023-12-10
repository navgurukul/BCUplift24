package org.Uplift24.Exam3;

public class Beverage implements Product{
    private String make;
    private long capacity;
    private String flavour;

    private double price;
    private double discountPercentage=20;

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

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public String getProductDescription() {
        return null;
    }

    @Override
    public double getDiscountApplied() {
       Double discount=price*0.2;
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
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
