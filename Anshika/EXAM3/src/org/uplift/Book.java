package org.uplift;

public class Book implements Product{
    private String title;
    private String author;
    private String genere;
    private int id;
    private double price;
    private double discountPrice;

    public Book(String title, String author, String genere) {
        this.title = title;
        this.author = author;
        this.genere = genere;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String getProductDescription() {
        String desc="Book of genere "+genere+" is written by "+author+" with title "+title;
        return desc;
    }

    @Override
    public double getDiscountApplied() {
        double discount=(getPrice()-getPrice()*0.1)*quantity;
        return discount;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
