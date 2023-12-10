package org.uplift.ordermanagementsystem;

public class Beverage implements Product{
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
    public String getProductDescription() {
        return flavour + " flavoured beverage " + make + " with capacity " + capacity + "ml";

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
    public String toString() {
        return "Beverage"  +"\n"+
                "id=" + id +"\n"+
                "price= " + price +"\n"+
                "discountPercentage= " + discountPercentage +"\n"+
                "make= " + make + "\n" +
                "capacity= " + capacity +"\n"+
                "flavour= " + flavour + "\n";
    }
}
