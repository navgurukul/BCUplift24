package org.ExamNo3;

abstract  class ProductDetails {
    private int id;
    private double price;
    private double discountPercentage;

    public ProductDetails(int id, double price, double discountPercentage) {
        this.id = id;
        this.price = price;
        this.discountPercentage = discountPercentage;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
