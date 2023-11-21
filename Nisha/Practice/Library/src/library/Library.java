package library;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> booksList = new ArrayList<>();
    public Library (){
        generateBooksData();
    }

    private void generateBooksData() {
        booksList.add(new Book("Irrfan Khan: A Life in Movies","Shubhra Gupta"));
        booksList.add(new Book("Monsoon","Abhay K"));
        booksList.add(new Book("The library.Book of Bihari Literature","Abhay K"));
        booksList.add(new Book("The Golden Years","Ruskin Bond"));
        booksList.add(new Book("Listen to Your Heart: The London Adventure","Ruskin Bond"));
        booksList.add(new Book("A Little library.Book of India: Celebrating 75 years of Independence","Ruskin Bond"));
        booksList.add(new Book("India’s Women Unsung Heroes","Meenakshi Lekhi"));
        booksList.add(new Book("Operation Khatma","Ashwini Bhatnagar"));
        booksList.add(new Book("War & Women","Dr MA Hasan"));
        booksList.add(new Book("War and Women","Dr MA Hasan"));
    }

}
