package org.uplift.orderMangement;

public interface Product {
    int id=0 ;
    double price=0;
    double discountPercentage = 0;


    String getProductDescription();
    double getDiscountApplied();
    double getPrice();
}
