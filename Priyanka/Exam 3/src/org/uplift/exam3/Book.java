package org.uplift.exam3;

public class Book implements Product{
    private String title;
    private String author;
    private String genere;
    private double discount;
    private double price;

    public Book(String title, String author, String genere,double discount,double price) {
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.discount = discount;
        this.price = price;
    }

    @Override
    public String getProductDescription() {
        return "Book Of " + genere + " written by " + author + " with title " + title;
    }

    @Override
    public double getDiscountApplied() {
        return discount;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genere='" + genere + '\'' +
                ", discount=" + discount +
                ", price=" + price +
                '}';
    }
}
