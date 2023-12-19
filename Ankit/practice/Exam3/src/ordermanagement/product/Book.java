package ordermanagement.product;

import java.util.Objects;

public class Book implements Product {
    private int id;
    private double price ;
    private double discountPercentage ;
    private String title;
    private String author;
    private String genre;

    public Book(int id, double price, double discountPercentage, String title, String author, String genre) {
        this.id = id;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.title = title;
        this.author = author;
        this.genre = genre;

    }

    @Override
    public String getProductDescription(){
        return " Book of genere "+ genre + " written by "+ author + " with title "+ title ;
    }

    @Override
    public double getDiscountApplied() {
        return (price*discountPercentage)/100 ;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public double netPrice(){
        return  price - getDiscountApplied();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o ;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return getProductDescription();
    }

    public int getId() {
        return id;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

}
