package org.ordermanagement;

public class Book extends Product{
    public String title;
    public String genere;
    public String author;
    public Book(int price,double discountPrice,String title,String genere,String author) {
        super("Book", price, discountPrice);
        this.title=title;
        this.author=author;
        this.genere=genere;
    }

    public String getProductDescription(){
        return "Title"+" "+title+" " +"Genere"+" "+genere+" "+"Author"+" "+author+" "+getPrice();
    }
    public  double getDiscountApplied(){
        return getPrice()-(getPrice()*getDiscountPrice());
    }
}
