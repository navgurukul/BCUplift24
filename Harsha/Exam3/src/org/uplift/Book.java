package org.uplift;

public  class Book implements Product{
    private int bookId;
    private String title;
    private String author;
    private String genere;
    private double bookPrice;
    //private double discountPercentage;

    public Book(int bookId, String title, String author, String genere, double bookPrice) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.bookPrice = bookPrice;
        //this.discountPercentage = discountPercentage;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }


    public String getProductDescription(){
        return "Book of genere " + genere+" is written by" + author +" with title "+title;

    }
    double discount;
    @Override
    public double getDiscountApplied() {
       discount= bookPrice*10/100;
       return discount;
    }
    double price;
    @Override
    public double netPrice(){
        price= bookPrice-getDiscountApplied();
        return price;

    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genere='" + genere + '\'' +
                ", bookPrice=" + bookPrice +
                ", discount=" + discount +
                ", price=" + price +
                '}';
    }
}
