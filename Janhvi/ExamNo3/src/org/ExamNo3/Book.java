package org.ExamNo3;

public class Book extends ProductDetails implements Product{
    private int id;
    private double price;
    private double discountPercentage;
    private String title;
    private String author;
    private String genere;

    public Book(int id,double price,double discountPercentage,String title, String author, String genere) {
        super(id,price,discountPercentage);
        this.title = title;
        this.author = author;
        this.genere = genere;
    }

    @Override
    public String getProductDescription() {

        return "Book of genere " + String.format(genere) +" is written by " + String.format(author)+  " with title "+String.format(title);
    }

    @Override
    public double getDiscountApplied() {
      double priceWithDiscount = getPrice() -(getPrice()*getDiscountPercentage());
      return priceWithDiscount;

    }

    @Override
    public double netPrice() {
        double netPriceforBook = getDiscountApplied();
        return netPriceforBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
