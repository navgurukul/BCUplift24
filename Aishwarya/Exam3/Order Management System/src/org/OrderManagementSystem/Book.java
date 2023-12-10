package org.OrderManagementSystem;

public class Book implements Product{
    private int id;
    private String title;
    private String author;
    private String genere;
    private double price;


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genere='" + genere + '\'' +
                ", price=" + price +
                '}';
    }

    public Book(int id, String title, String author, String genere, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.price = price;
    }


    @Override
    public String getProductDescription() {
        return "Book is of genere " + genere + " is written by " + author + " with title " + title;
    }

    @Override
    public double getDiscountApplied() {
       double percentage =  Product.discountPercentage + 0.1;
       double discountPrice = price * percentage;
        return discountPrice ;
    }

    public double getPrice() {

        return price;
    }
}
