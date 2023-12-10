package org.uplift.orderMangement;

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
    public String getProductDescription() {
        return null;
    }

    @Override
    public double getDiscountApplied() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
