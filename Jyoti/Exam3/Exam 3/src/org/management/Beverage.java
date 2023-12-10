package org.management;
public class Beverage extends Product {
    private String flavour;
    private String make;
    private int capacity;
    public Beverage(String flavour, String make, int capacity, double price, int quantity) {
        super("Beverage", price, quantity);
        this.flavour = flavour;
        this.make = make;
        this.capacity = capacity;
    }
    public String getDescription() {
        return String.format("%s flavored beverage %s with capacity %dml", flavour, make, capacity);
    }
}
