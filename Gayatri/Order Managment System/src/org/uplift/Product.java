package org.uplift;

public interface Product {
    int getId();
    double getPrice();
    double getDiscountPercentage();
    String getProductDescription();
    double getDiscountApplied();
    double netPrice();
}
