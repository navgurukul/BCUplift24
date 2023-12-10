package org.ExamNo3;

public class Beverage extends ProductDetails implements Product {
    private String make;
    private long capacity;
    private String flavour;

    public Beverage(int id, double price, double discountPercentage,String make,long capacity,String flavour) {
        super(id, price, discountPercentage);
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
    }

    @Override
    public String getProductDescription() {
        return getFlavour() + "flavoured " + getMake() + "with capacity " + getCapacity() + "ml";
    }

    @Override
    public double getDiscountApplied() {
        double priceWithDiscount = getPrice() -(getPrice()*getDiscountPercentage());
        return priceWithDiscount;
    }

    @Override
    public double netPrice() {
        double netPriceforBook = getDiscountApplied();
        return netPriceforBook;
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
        return "Beverage{" +
                "make='" + make + '\'' +
                ", capacity=" + capacity +
                ", flavour='" + flavour + '\'' +
                '}';
    }
}
