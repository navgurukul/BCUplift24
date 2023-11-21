package library;

public class Book {
    String bookName;
    String bookAuthorName;
    public Book(String bookName, String bookAuthorName){
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
    }
    public String getBookName(){
        return bookName;
    }
    public String getBookAuthorName() {
        return bookAuthorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthorName='" + bookAuthorName + '\'' +
                '}';
    }
}
