package org.uplift.ordermanagementsystem;

public class Beverage implements Product{
    private String make;
    private long capacity;
    private String flavour;

    public Beverage(String make, long capacity, String flavour) {
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
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
    public int getid() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public double getDiscountPercentage() {
        return getDiscountPercentage();
    }

    @Override
    public String getProductDescription() {
        return String.format("%s flavored beverage %s with capacity %dml", flavour, make, capacity);
    }

    @Override
    public double getDiscountApplied() {
        return Product.super.getDiscountApplied();
    }


    public double netPriceOfBeverage(Product p){
        //net price = real price - discounted price
        return p.getPrice()-p.getDiscountApplied();
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
