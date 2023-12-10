package org.uplift.orderMangement;

public class Book implements Product {

    private String title;
    private String author;
    private String genere;

    public Book(String title, String author, String genere) {
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
        return null;
    }

    @Override
    public double getDiscountApplied() {

        return price*discountPercentage/100;
    }



    @Override
    public double getPrice() {
        return 0;
    }
}
