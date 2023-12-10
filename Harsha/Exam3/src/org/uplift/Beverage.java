package org.uplift;

public class Beverage implements Product{
    private int beverageId;
    private String make;
    private long capacity;
    private String flavour;
    private double beveragePrice;

    public Beverage(int beverageId, String make, long capacity, String flavour, double beveragePrice) {
        this.beverageId = beverageId;
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
        this.beveragePrice = beveragePrice;
    }

    public int getBeverageId() {
        return beverageId;
    }

    public void setBeverageId(int beverageId) {
        this.beverageId = beverageId;
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

    public double getBeveragePrice() {
        return beveragePrice;
    }

    public void setBeveragePrice(double beveragePrice) {
        this.beveragePrice = beveragePrice;
    }

    @Override
    public String getProductDescription() {
        return flavour +"flavoured beverage "+make+" with capacity "+capacity+" ml";
    }
    double discount;
    @Override
    public double getDiscountApplied() {
         discount = beveragePrice*20/100;
        return discount;
    }
    double price;

    @Override
    public double netPrice() {
        price = beveragePrice-getDiscountApplied();
        return price;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "beverageId=" + beverageId +
                ", make='" + make + '\'' +
                ", capacity=" + capacity +
                ", flavour='" + flavour + '\'' +
                ", beveragePrice=" + beveragePrice +
                ", discount=" + discount +
                ", price=" + price +
                '}';
    }
}
