package com.example.LibraryManagement2.libraryService;


import com.example.LibraryManagement2.book.Book;
import com.example.LibraryManagement2.libraryRepository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
    public class LibraryService {

        @Autowired
        LibraryRepository lr;

        public boolean addBook(Book b, int q){
            lr.addBook(b,q);
            return true;
        }
        public boolean returnBook(Book b,int q){
            lr.returnBook(b,q);
            return true;

        }
        public boolean addBooks(Book b, int q) {
            lr.addBookInLibrary(b,q);
            return true;
        }

        public boolean BorrowBook(Book b,int q) {
            lr.BorrowBookFromLibrary(b,q);
            return true;
        }
        public Integer removebook(Book b){
            return lr.deleteBook(b);

        }


        public Book findById(String id) {
            return lr.findBookById(id).getKey();
        }

        public Map<Book,Integer> getMap(){
            return lr.getBookUserMap();
        }



}
