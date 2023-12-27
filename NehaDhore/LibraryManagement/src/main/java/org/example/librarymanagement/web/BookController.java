package org.example.librarymanagement.web;

import org.example.librarymanagement.book.Book;
import org.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
 private BookService bs;

    @GetMapping("/")
    public String test(){
        return "Hello & Welcome to our Library";
    }

    @PostMapping("/Books")
    public ResponseEntity<Boolean> addBook(@RequestBody Book b){
        boolean result = bs.addBook(b);
        if(!result) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(true);
    }
    @GetMapping("/Books/{id}")

    public ResponseEntity<Book> findBook(@PathVariable String id){
        Book b = bs.findBook(id);
        if(b == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(b);



    }
    @PutMapping("/Books")

    public boolean updateBook(@RequestBody Book b) {
        boolean update = bs.updateBook(b);
        if (update) return true;
        return false;

    }
    @DeleteMapping("/Books")

        public ResponseEntity<Boolean> deleteStudent(@RequestBody Book b){
            boolean delete = bs.deleteBook(b);
//            System.out.println("Just called method");
        if(!delete) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(true);
        }
    @PostMapping("/BookList")
    public ResponseEntity<List<Book>> addMoreBook(@RequestBody List<Book> books){
        List<Book> bookList = bs.addMoreBooks(books);
        if(books == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(books);
    }
    @PutMapping("/BorrowBook")
    public boolean borrow(@RequestBody Book b){
        boolean result = bs.borrowBook(b);
        return result;
    }
    @PutMapping("/returnBook")
    public boolean returnBook(@RequestBody Book b){
        boolean result = bs.returnBook(b);
        return result;
    }



}
