package org.OrderManagementSystem;

public class Book extends ProductClass implements Product{
    private String title;
    private String author;
    private String genere;
    public Book(int id, double price, String title, String author, String genere) {
        super(id, price);
        this.title = title;
        this.author = author;
        this.genere = genere;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String getProductDescription() {
        return "it is Book of genere "+getGenere()+" is written by "+getAuthor()+" with title "+getTitle();
    }

    @Override
    public double getDiscountApplied() {
        return getPrice()*(10/100);
    }
    public double netPrice(){
        return getPrice()-getDiscountApplied();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
