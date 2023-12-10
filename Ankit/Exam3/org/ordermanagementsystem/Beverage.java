package org.ordermanagementsystem;

import java.util.Objects;

public class Beverage implements Product{
    int id = 0;
    double price = 0.0;
    double discountPercentage = 0.0 ;
    private String make ;
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
    public String getProductDescription() {
        return flavour + " flavoured "+ make + " with capacity "+ capacity + "ml";
    }

    @Override
    public double getDiscountApplied() {
        return (price * discountPercentage)/100;
    }

    @Override
    public double getPrice() {
        return price;
    }
    public double netPrice(){
        return price - getDiscountApplied();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beverage beverage = (Beverage) o ;
        return id == beverage.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "id=" + id +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", make='" + make + '\'' +
                ", capacity=" + capacity +
                ", flavour='" + flavour + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
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
}
