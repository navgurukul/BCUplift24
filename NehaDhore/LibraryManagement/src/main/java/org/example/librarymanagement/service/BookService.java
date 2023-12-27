package org.example.librarymanagement.service;

import org.example.librarymanagement.book.Book;
import org.example.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookRepository br;

    public boolean addBook(Book b) {
        return br.addBook(b);
    }

    public Book findBook(String id) {
        return (br.findBook(id));
    }

    public boolean updateBook(Book b) {

        return br.updateBook(b);
    }

        public boolean deleteBook(Book b){

        System.out.println("trying");
        return br.deleteBook(b);

    }
    public List<Book> addMoreBooks(List<Book> books){
        return br.addMoreBooks(books);
    }

    public boolean borrowBook(Book b){
       return br.borrowBook(b);

    }
    public boolean returnBook(Book b){
        return br.returnBook(b);
    }



}




