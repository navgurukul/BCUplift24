package OnlineShopping;

public class Book implements Product{

    private String productId;
    private double price;
    private double discountPercentage;

    private String title;
    private String author;
    private String genere;

  //  private List<OrderManagement> booklist=new ArrayList<>();


    public Book(String productId, double price, double discountPercentage, String title, String author, String genere) {
        this.productId = productId;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.title = title;
        this.author = author;
        this.genere = genere;

    }

    public String getProductId() {
        return productId;
    }

    @Override
   public String getProductDescription() {
    return "Book details are:" + "title is :" + title+ "author is :" + author + "genere is :" + genere;

    }


    @Override
    public double getDiscountApplied() {

        return getDiscountPercentage()* price;
    }

    @Override
    public double getNetprice() {
        return  price- getDiscountApplied();
    }

    public double getPrice() {
        return price ;
   }


    @Override
    public double getNetPrice() {
        return price- getDiscountApplied();
    }

    public double getDiscountPercentage() {
        return discountPercentage;
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
        return "Beverage{" +
                "productId='" + productId + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}







