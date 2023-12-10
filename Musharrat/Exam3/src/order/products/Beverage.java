package order.products;

import java.util.Objects;

public class Beverage implements Product{
    private int id;
    private double price;
    private static final double DISCOUNTPERCENTAGE = 20;
    private String make;
    private long capacity;
    private String flavour;

    public Beverage(int id, double price, String make, long capacity, String flavour) {
        this.id = id;
        this.price = price;
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
    }

    public int getId() {
        return id;
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
        return flavour+" flavoured beverage "+make+ " with capacity " +capacity +"ml";
    }

    @Override
    public double getDiscountApplied() {
        return price*DISCOUNTPERCENTAGE/100;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getProductDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beverage beverage = (Beverage) o;
        return id == beverage.id && capacity == beverage.capacity && Objects.equals(make, beverage.make) && Objects.equals(flavour, beverage.flavour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, capacity, flavour);
    }
}
