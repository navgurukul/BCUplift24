package org.example.librarymanagement.book;

import java.util.Objects;

public class Book {
    private String id;
    private String title;
    private String genre;
    private String author;

    public Book(String id, String title, String genre, String author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(genre, book.genre) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, author);
    }
}
