package org.ordermanagement;

public abstract class Product {
    private String  productName;
    private double price;
    private double discountPrice;

    public Product(String productName, double price, double discountPrice) {
        this.productName = productName;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }
    abstract String getProductDescription();
    public abstract double getDiscountApplied() ;

}
