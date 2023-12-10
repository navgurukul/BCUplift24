package org.OrderManagementSystem;

 public class Beverage implements Product{
//    private String make;
    private long capacity;
    private String flavour;

    public Beverage( long capacity, String flavour) {
//        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
    }

     public String getProductDescription(){
        return "Flavour: "+flavour+"\n"+ "Capacity: "+capacity;

     }

     @Override
     public double getDiscountPercentage() {
         return 0;
     }

     @Override
     public double getPrice() {
         return 0;
     }

     public double getDiscountApplied(Product p){
        return netPrice() - p.getDiscountPercentage();

     }
     public double netPrice(){
        return netPrice();

     }

    @Override
    public String toString() {
        return "Beverage{" +
                ", capacity=" + capacity +
                ", flavour='" + flavour + '\'' +
                '}';
    }
}
