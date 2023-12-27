package com.example.LibraryManagement2.libraryRepository;

import com.example.LibraryManagement2.book.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository


    public class LibraryRepository {
        //private SortedSet<Book> books= new TreeSet<>();
        private Map<Book, Integer> bookUserMap=new HashMap<>();

        public boolean addBook(Book b, int q){
            bookUserMap.put(b,q);
            return true;
        }

        public  boolean returnBook(Book b, int q){
            if (bookUserMap.containsKey(b)){
                int previousQuantity= bookUserMap.get(b);
                bookUserMap.put(b,previousQuantity + q);
            }
            else{
                bookUserMap.put(b,q);
            }
            return true;
        }

        public boolean addBookInLibrary(Book b,int q){   // return is same like this
            if (bookUserMap.containsKey(b)){
                int currentQuantity= bookUserMap.get(b);
                bookUserMap.put(b,currentQuantity+q);
            }else {
                bookUserMap.put(b, q);    //if not in library
            }
            return true;
        }

        public boolean BorrowBookFromLibrary(Book b, Integer q){
            if (bookUserMap.containsKey(b)) {
                int availableQuantity = bookUserMap.get(b);
                if (availableQuantity >= q) {
                    bookUserMap.put(b, availableQuantity - q);
                    return true;
                } else {
                    return false;
                }
            }else{
                return false;
            }
        }

        public Integer deleteBook(Book b){
            return bookUserMap.remove(b);
        }

        public Map.Entry<Book,Integer> findBookById(String id) {
            return bookUserMap.entrySet().stream().filter(entry -> entry.getKey().getId().equals(id)).findFirst().orElse(null);
        }


        public Map<Book, Integer> getBookUserMap() {
            return bookUserMap;
        }




}
