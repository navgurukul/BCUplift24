package org.exam3;
import java.util.HashSet;
import java.util.Set;
public class Beverage extends Product {
   public String flavour;
   public String make;
   public long capacity;

    public Beverage(String flavour, String make, long capacity, double price) {
        super("Beverage", price, 0.2);
        this.flavour = flavour;
        this.make = make;
        this.capacity = capacity;
    }

    @Override
    public String getDescription() {
        return flavour + " flavored beverage " + make + " with capacity " + capacity  + " ml "+" the name of "+name+" the price was "+price;
    }
}

//public class Beverage extends Product{
//    private  String make;
//    private long capacity;
//
//    private String flavour;
//
//
//    public Beverage(int id, double price, double discountPercentage, String make, long capacity, String flavour) {
//        super(id, price, discountPercentage);
//        this.make = make;
//        this.capacity = capacity;
//        this.flavour = flavour;
//    }
//    public String getProductDescription() {
//       // return flavour +make+capacity;
//
//        return flavour + " flavored beverage " + make + " with capacity " + capacity + "ml";
//        }
//
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
