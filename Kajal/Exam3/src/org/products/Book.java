package org.products;

public class Book implements Product{
    private String title;
    private String author;
    private String genere;
    private int id;
    private double price;
    private double discountPercentage;
    public Book(String title, String author, String genere, int id, double price){
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.id = id;
        this.price = price;
        this.discountPercentage = 10;
    }
    @Override
    public String getProductDescription() {
        return "Book of genere "+genere+" is written by "+ author+" with title "+ title;
    }

    @Override
    public double getDiscountApplied() {
        return price*discountPercentage/100;
    }

    @Override
    public double netPrice() {
        return price;
    }
}
