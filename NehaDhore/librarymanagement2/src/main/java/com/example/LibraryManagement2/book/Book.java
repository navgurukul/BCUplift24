package com.example.LibraryManagement2.book;
import java.util.Objects;

public class Book {



        private String id;
        private String title;
        private String author;



        public Book(String id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;

        }

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }



        @Override
        public String toString() {
            return "Book{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return  Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, title, author);
        }

}
