package org.order;

public  class Book implements Product{
    private String title;
    private String author;
    private String genere;
    private double price;
    public Book(String title, String author, String genere,double price) {
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.price=price;
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
        return "the Author is "+ author + "and book title "+ title +" and genere "+ genere;
    }

    @Override
    public double getPrice() {
        return price-getDiscountApplied();
    }

    @Override
    public double getDiscountApplied() {

        return price*0.1;
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
