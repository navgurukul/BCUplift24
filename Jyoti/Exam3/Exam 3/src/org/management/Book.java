package org.management;
public class Book extends Product {
    private String genre;
    private String author;
    private String title;
    public Book(String genre, String author, String title, double price, int quantity) {
        super("Book", price, quantity);
        this.genre = genre;
        this.author = author;
        this.title = title;
    }
    public String getDescription() {
        return String.format("Book of genre %s written by %s with title %s", genre, author, title);
    }
}
