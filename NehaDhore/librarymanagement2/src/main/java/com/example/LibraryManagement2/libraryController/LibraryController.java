package com.example.LibraryManagement2.libraryController;


import com.example.LibraryManagement2.book.Book;
import com.example.LibraryManagement2.libraryService.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LibraryController {

    @Autowired
    LibraryService ls;


    @PostMapping("/book/{q}")
    public ResponseEntity<Boolean> addBook(@RequestBody Book b, @PathVariable int q){
        boolean result= ls.addBooks(b,q);
        if(result){
            Map<Book,Integer> l = ls.getMap();
            return ResponseEntity.ok(true);

        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/book")
    public ResponseEntity<Map<Book,Integer>> add(){
        Map<Book,Integer> bookUserMap=new HashMap<>();
        bookUserMap.put(new Book("1","harry","harypotter"),2);
        bookUserMap.put(new Book("3","agnipankh","abdul kalam"),5);
        return ResponseEntity.ok(bookUserMap);
    }

    @GetMapping("/book/{id}/{title}/{author}")           //done
    public String getBook(@PathVariable String id,@PathVariable String title,@PathVariable String author){
        return "id:"+ id + "title:"+ title + "author:" + author;
    }

    @GetMapping("/book/{id}")              //done
    public ResponseEntity<Book> getBookFromId(@PathVariable String id){
        Book b= new Book("1","harry Potter","harray potter");
        if (b.getId().equals(id)){
            return ResponseEntity.ok(b);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/book/{q}")
    public ResponseEntity<Boolean> deleteBookFromLibrary(@RequestBody Book b,@PathVariable  int q){
        boolean result= ls.BorrowBook(b,q);
        if (!result) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(true);
        }
    }

    @PutMapping("book/{q}")
    public ResponseEntity<Boolean> returnBook(@RequestBody Book b,@PathVariable int q){
        boolean result= ls.returnBook(b,q);
        if(result) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

}

//{
//        "Book{id='3', title='agnipankh', author='abdul kalam',quantity='10'}": {
//        "userid": "4",
//        "name": "gayatri"
//        },
//        "Book{id='1', title='harry', author='harypotter',quantity='5'}": {
//        "userid": "2",
//        "name": "dipti"
//        }
//        }