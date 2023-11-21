package library;

import java.util.ArrayList;

public class Libraryutils {
    Library l1 = new Library();

    public void addBook(String bookName,String authorName){

        Book b1 = new Book(bookName,authorName);
        l1.booksList.add(b1);
        System.out.println("Book: "+bookName+", Author: "+authorName+", has been added");
    }
    public void removeBook(String bookName) {
        Book bookToRemove = null;
        for (Book book : l1.booksList) {
            if (book.getBookName().equals(bookName)) {
                bookToRemove=book;
                System.out.println("library.Book has been removed from the library.Library");
                break;
            } else {
                System.out.println(bookName + " is not present in the library.Library");
            }
        }
    }

    public void findBook(String bookName) {
        for (Book book : l1.booksList) {
            if (book.getBookName().equals(bookName)) {
                System.out.println(bookName + " is in the library.Library of author name: " + book.getBookAuthorName());
            } else {
                System.out.println(bookName + " is not found in the library.Library");
            }
        }
    }
    ArrayList<Book> booksOfAnAuthor = new ArrayList<>();
    public ArrayList<Book> generateBooksOfAnAuthorData (String authorName){
        for (Book book : l1.booksList) {
            if (book.getBookAuthorName().equals(authorName)) booksOfAnAuthor.add(book);
            else {
                System.out.println(authorName + " books are not in the library.Library ");
                return booksOfAnAuthor;
            }
        }
        return booksOfAnAuthor;

    }
    public void showLibraryBooks(){
        for(Book book:l1.booksList){
            System.out.println("Book: "+book.getBookName()+" AuthorName: "+book.getBookAuthorName());
        }
    }
}
