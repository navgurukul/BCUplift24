package OnlineShopping;

public class Beverage implements Product {
    private String productId;
    private double price;
    private double discountPercentage;
    private String make;
    private long capacity;
    private String flavour;

    public Beverage(String productId, double price, double discountPercentage, String make, long capacity, String flavour) {
        this.productId = productId;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.make = make;
        this.capacity = capacity;
        this.flavour = flavour;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public String getProductDescription() {
        return "beverage details are :" + "make: "+ make + "capacity" + capacity + "flavor" + flavour;
    }

    @Override
    public double getDiscountApplied() {
        return getDiscountPercentage()* getPrice() ;
    }

    @Override
    public double getNetprice() {
        return price- getDiscountApplied();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double getNetPrice() {

        return price- getDiscountApplied();
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

    @Override
    public String toString() {
        return "Book{" +
                "productId='" +  productId + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", make='" + make     + '\'' +
                ", capacity=" + capacity      +
                ", flavour='" + flavour         + '\'' +
                '}';
    }
}
