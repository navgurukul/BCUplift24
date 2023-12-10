public class Beverage implements Product{

    private int id;
    private double price = 50;
    private double discountPercentage = 20;
    private String make;
    private long capacity;
    private String flavour;

    public Beverage(String make, long capacity, String flavour) {
        this.id = (int) Math.random();
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
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

    public double getPrice(){
        return price;
    }


    public String getProductDescription(){
        return "Beverage Details : "+getFlavour()+" flavoured beverage "+getMake()+" with capacity "+getCapacity()+" ml";
    }

    public double getDiscountApplied(){
        return (double)(getPrice()*discountPercentage)/100;
    }

    @Override
    public String toString() {
        return "\nBeverage : " +
                "id=" + id +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", make='" + make + '\'' +
                ", capacity=" + capacity +
                ", flavour='" + flavour + '\'' +
                "\n";
    }
}
