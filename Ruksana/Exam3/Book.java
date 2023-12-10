package org.exam3;
import java.util.HashSet;
import java.util.Set;
public class Book extends Product {
    String genre;
    String author;
    String title;

    public Book(String genre, String author, String title, double price) {
        super("Book", price, 0.1);
        this.genre = genre;
        this.author = author;
        this.title = title;
    }

    @Override
    public String getDescription() {
        return "Book of genre  " + genre + "  written by " + author + "  with title  " + title+"the price "+price;
    }
}
























//public class Book extends Product {
//
//    private String title;
//    private String author;
//    private String genere;
//
////    public Book(String title, String author, String genere, double price) {
////        super("Book", price, 0.1);
////        this.title = title;
////        this.author = author;
////        this.genere = genere;
////    }
//
//
//    public Book(int id, double price, double discountPercentage, String title, String author, String genere) {
//        super(id, price, discountPercentage);
//        this.title = title;
//        this.author = author;
//        this.genere = genere;
//    }
//
//    public String getProductDescription() {
//        return "with title" + title + "written by" + author + "Book of genre" + genere;
//
//
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
