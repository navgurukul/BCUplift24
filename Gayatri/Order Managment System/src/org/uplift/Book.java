package org.uplift;

import java.util.HashMap;
import java.util.Map;

public class Book implements Product {
    private int id;
    private double price;
    private double discountPercentage;
    private String title;
    private String author;
    private String genre;

    public Book(int id, double price, double discountPercentage, String title, String author, String genre) {
        this.id = id;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public String getProductDescription() {
        return "Book of genre " + genre + " is written by " + author + " with the title " + title;
    }

    @Override
    public double getDiscountApplied() {
        return price - (price * discountPercentage / 100);
    }

    @Override
    public double netPrice() {
        return getDiscountApplied();
    }
}
