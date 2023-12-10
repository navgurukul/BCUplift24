package order.products;

import java.util.Objects;

public class Book implements Product{
    private int id;
    private double price;
    private static final double DISCOUNTPERCENTAGE = 10;
    private String title;
    private String author;
    private String genre;


    public Book(int id, double price, String title, String author, String genre) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public int getId() {
        return id;
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

    @Override
    public String getProductDescription() {
        return "Book of genre "+genre+" written by "+author+" with title "+ title;
    }

    @Override
    public double getDiscountApplied() {
        return price* DISCOUNTPERCENTAGE /100;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getProductDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Double.compare(price, book.price) == 0 && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, genre);
    }
}
