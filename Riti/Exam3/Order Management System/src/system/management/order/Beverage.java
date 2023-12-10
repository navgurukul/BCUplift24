package system.management.order;

public class Beverage implements Product {
    int id;
    double price;
    private  String make;
    private long capacity;
    private  String flavour;

    public Beverage(String make, long capacity, String flavour,int id,double price) {
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
        this.price=price;
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

    @Override
    public double getDiscountApplied() {
        return 20;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
