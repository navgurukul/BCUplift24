package org.uplift;

public class Beverage implements Product{
    private String make;
    private long capacity;
    private String flavour;
    private int id;
    private double price;
    private double discountPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String getProductDescription() {
        String desc=flavour+" flavoured beverage "+make+" with capacity "+capacity;
        return desc;
    }

    @Override
    public double getDiscountApplied() {
        double discount=(getPrice()-getPrice()*0.2)*quantity;
        return discount;
    }

    @Override
    public double getPrice() {

        return getPrice()*quantity-discount;

    }

    public Beverage(String make, long capacity, String flavour) {
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }
}
