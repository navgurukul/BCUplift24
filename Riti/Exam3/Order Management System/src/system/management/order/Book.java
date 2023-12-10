package system.management.order;

public class Book implements Product{
    private String title;
    private String author;
    private String genere;
    double price;

    public Book(String title, String author, String genere,double price) {
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.price=price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }

    @Override
    public double getDiscountApplied() {
        return 10;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
