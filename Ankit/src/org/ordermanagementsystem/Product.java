package org.ordermanagementsystem;

public interface Product {
    int id = 0;
    double price = 0.0;
    double discountPercentage = 0.0 ;

    public String getProductDescription();
    public double getDiscountApplied();
    public double getPrice();

    
}
