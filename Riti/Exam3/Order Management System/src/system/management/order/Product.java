package system.management.order;

public interface Product {
    int id = 0;
    double price=0;
    double discountPercentage=0;

    public String toString();
    double getDiscountApplied();
    double getPrice();

}
