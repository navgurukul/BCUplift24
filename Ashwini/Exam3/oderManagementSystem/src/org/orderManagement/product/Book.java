package org.orderManagement.product;

public class Book implements Product{
    private int id;
    private String title;
    private String author;
    private String genere;
    private double price;
    private double discountpercentage = 10;


    public Book(int id,String title, String author, String genere, double price ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.price = price;
    }



    @Override
    public String getProductDescription() {
        return "Book of the {"+
                ",genere "+  genere +
                " written by "+ author +
                " with title" + title;
    }

    @Override
    public double getDiscountApplied() {
        return price * (discountpercentage/100.0);
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
    public double getPrice() {
        return price;
    }
    public  double netPrice(){
        double discountAmount = getDiscountApplied();
        return  price - discountAmount;
    }
    public void setPrice(double price1){
    }
}
