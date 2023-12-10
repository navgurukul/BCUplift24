package org;

public class Beverage implements Product{
    int id;
    double price;
    public final double discountPercentage = 20;
    String make;
    Long capacity;
    String flavour;

    public Beverage(int id, double price, String make, Long capacity, String flavour) {
        this.id = id;
        this.price = price;
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
    }
    public String getProductDescription(){
        return "Book Name:-" +" "+make +" "+
                "Book author"+ " "+capacity +" "+
                "Book genere"+ " "+flavour +" "+
                "Book Id" + " "+id + " "+
                "Book Price"+" "+price;
    }

    @Override
    public double getDiscountApplied(){
        return price - price * discountPercentage;
    }
    public double getPrice(){
        return price;
    }
}
