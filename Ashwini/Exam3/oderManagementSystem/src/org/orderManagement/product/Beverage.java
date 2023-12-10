package org.orderManagement.product;

public class Beverage implements Product {
    private int id;
    private String flavour;
    private String make;
    private long capacity;
    private double price;
    private double discountpercentage = 20;


    public Beverage(int id,String flavour, String make, long capacity, double price) {
        this.id =id;
        this.flavour = flavour;
        this.make = make;
        this.capacity = capacity;
        this.price = price;
    }

    @Override
    public String getProductDescription() {

        return "Beverage{"+
                flavour + "flvoured beverage "+
                make + "with capacity "+ capacity + "ml";
    }

    @Override
    public double getDiscountApplied() {
        return price * (discountpercentage/100.0);
    }

    public  double netPrice(){
        double discountAmount = getDiscountApplied();
        return  price - discountAmount;
    }


    @Override
    public double getPrice() {
        return price;
    }
}
