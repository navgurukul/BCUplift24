public class Book implements Product {

    private int id;
    private double price = 600;
    private double discountPercentage = 10.0;
    private String title;
    private String author;
    private String genere;


    public Book(String title, String author, String genere) {
        this.id = (int) Math.random();
        this.title = title;
        this.author = author;
        this.genere = genere;
    }


    public String getProductDescription(){
        return "Details of Product : "+"Book of genere "+getGenere()+" is written by "+getAuthor()+" , Author = "+getAuthor();
    }

    public double getDiscountApplied(){
        return (double)(getPrice()*discountPercentage)/100;
    }

    public double getPrice(){
        return price;
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
        return "\nBook : " +
                "id=" + id +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genere='" + genere + '\'' +
                "\n";
    }
}
