package org.uplift.ordermanagementsystem;

public interface Product {

    int getid();

    double getPrice();

    double getDiscountPercentage();

    String getProductDescription();

    default double getDiscountApplied() {
        double discount = getPrice() * (getDiscountPercentage() / 100.0);
        return getPrice() - discount;
    }
}





