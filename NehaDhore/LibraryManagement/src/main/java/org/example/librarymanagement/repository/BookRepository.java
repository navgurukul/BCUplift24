package org.example.librarymanagement.repository;

import org.example.librarymanagement.book.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository

public class BookRepository {
    List<Book> bookList = new ArrayList<>();
    List<Book> returnbookList = new ArrayList<>();

    public boolean addBook(Book b) {
        if(findBook(b.getId()) != null){
            return false;
        }
        return bookList.add(b);
    }

    public Book findBook(String id) {
        return bookList.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean updateBook(Book b) {
        Book result = findBook(b.getId());
        if (result == null) {
            return addBook(b);
        }
        return false;
    }

    public boolean deleteStudent(Book b) {
        return bookList.remove(b);
    }

    public boolean deleteBook(Book b) {
        if (findBook(b.getId()) == null) {
            System.out.println("book not found");
            return false;
        }
        System.out.println("book removed");
        return bookList.remove(b);
    }

    public List<Book> addMoreBooks(List<Book> books){
        bookList.addAll(books);
        return bookList;
    }
    public boolean borrowBook(Book b){
        Book result = findBook(b.getId());
        if(result == null){
            return false;
        }
        bookList.remove(b);
        returnbookList.add(b);
        return true;
    }
    public boolean returnBook(Book b){
        String id =  b.getId();
        Book result = returnbookList.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        if(result == null){
            return false;
        }
        return true;
    }
}



