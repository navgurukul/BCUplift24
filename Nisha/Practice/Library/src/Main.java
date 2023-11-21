import library.Book;
import library.Library;
import library.Libraryutils;

public class Main {
    public static void main(String[] args) {
        //Book b1 = new Book();

        Library l1 = new Library();
        Libraryutils lu = new Libraryutils();
        lu.addBook("The Companion", "ACSE");
        lu.removeBook("Irrfan Khan: A Life in Movies");
        lu.showLibraryBooks();
    }
}