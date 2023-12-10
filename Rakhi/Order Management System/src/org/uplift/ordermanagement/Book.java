package org.uplift.ordermanagement;

public class Book implements Product{
    private String title;
    private String author;
    private String genere;
    private double price;


    @Override
    public double getDiscountApplied() {
        return (10*price)/100;
    }

    @Override
    public double netPrice() {
        return price;
    }

    public Book(String title,String author,String genere,double price) {
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.price = price;
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
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genere='" + genere + '\'' +
                ", price=" + price +
                '}';
    }
}
