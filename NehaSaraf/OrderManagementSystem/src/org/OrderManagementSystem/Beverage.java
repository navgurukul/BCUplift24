package org.OrderManagementSystem;

public class Beverage extends ProductClass implements Product{
    private String make;
    private long capacity;
    private String flavour;

    public Beverage(int id, double price, String make, long capacity, String flavour) {
        super(id, price);
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
        return "it is "+getFlavour()+" flavoured beverage "+getMake()+" with Capacity "+getCapacity()+" ml.";
    }

    @Override
    public double getDiscountApplied() {
        return getPrice()*(20/100);
    }
    public double netPrice(){
        return getPrice()-getDiscountApplied();
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
