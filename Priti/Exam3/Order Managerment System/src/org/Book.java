package org;

public class Book implements Product{
    int id;
    double price;
    public final double discountPercentage = 10;
    String title;
    String author;
    String genere;

    public Book(int id, double price, String title, String author, String genere) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.author = author;
        this.genere = genere;
    }

    public String getProductDescription(){
        return "Book Name:-" + title +" "+
                "Book author"+ author +" "+
                "Book genere"+ genere +" "+
                "Book Id" + id + " "+
                "Book Price"+ price;
    }

    @Override
    public double getDiscountApplied(){
        return price - price * discountPercentage; ;
    }
    public double getPrice(){
        return price;
    }
    public double getDiscountPercentage() {
        return discountPercentage;
    }

}
