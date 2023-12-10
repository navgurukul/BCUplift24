package org.ordermanagement;

public  class Beverage extends Product{
    public String make;
    public long capacity;
    public String flavour;

    public Beverage( double price, double discountPrice, String make, long capacity, String flavour) {
        super("Beverage", price, discountPrice);
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
    }

    public String getProductDescription(){
        return getProductName()+" "+"flavour"+" "+flavour+" "+"Make"+" "+make+" "+"Capacity"+" "+capacity;
    }

    public  double getDiscountApplied(){
        return getPrice()-(getPrice()*getDiscountPrice());
    }
}
