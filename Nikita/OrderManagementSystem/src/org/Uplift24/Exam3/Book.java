package org.Uplift24.Exam3;

public class Book implements Product{
    private String title;
    private String author;
    private String genere;
    private int price;
    private double discountPercentage=10;

    public Book(String title, String author, String genere, int price) {
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

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public String getProductDescription() {
        return null;
    }

    public double getDiscountApplied() {
        Double discount=price*0.1;
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
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}
