package org.products;

public class Beverage implements Product{
    private String make;
    private long capacity;
    private String flavour;
    private int id;
    private double price;
    private double discountPercentage;
    public Beverage(String make, long capacity, String flavour, int id, double price){
        this.make =  make;
        this.capacity = capacity;
        this.flavour = flavour;
        this.id = id;
        this.price = price;
        this.discountPercentage = 20;
    }
    @Override
    public String getProductDescription() {
        return flavour+" flavoured beverage "+ make+" with capacity "+ capacity;
    }

    @Override
    public double getDiscountApplied() {
        return price*discountPercentage/100;
    }

    @Override
    public double netPrice() {
        return price;
    }
}
