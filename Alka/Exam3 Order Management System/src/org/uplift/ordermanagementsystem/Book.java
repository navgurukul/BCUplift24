package org.uplift.ordermanagementsystem;
public class Book implements Product{
    private final String title;
    private final String author;
    private final String genere;

    public Book(String title, String author, String genere) {
        this.title = title;
        this.author = author;
        this.genere = genere;
    }

    public String getTitle() {
        return title;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public int getid() {
        return getid();
    }

    @Override
    public double getPrice() {
        return getPrice();
    }

    @Override
    public double getDiscountPercentage() {
        return getDiscountPercentage();
    }


    @Override
    public String getProductDescription() {
        return String.format("Book of genre %s written by %s with title %s", genere, author, title);
    }

    @Override
    public double getDiscountApplied() {
        return Product.super.getDiscountApplied();
    }

    public double netPriceOfBook(Product p){
        //net price = real price - discounted price
        return p.getPrice()-p.getDiscountApplied();
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
