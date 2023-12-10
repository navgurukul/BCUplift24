package org.OrderManagementSystem;
 public class Book implements Product{
    private String Title;
    private String author;
    private String genere;

    public Book(String title, String author, String genere) {
        Title = title;
        this.author = author;
        this.genere = genere;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenere() {
        return genere;
    }
@Override
    public String getProductDescription(){
        return "0";//"Book Name: "+ getTitle()+"\n"+ "Author Name: "+getAuthor()+"\n"+"Genere: "+getGenere();

    }

     @Override
     public double getDiscountPercentage() {
         return 0;
     }

     @Override
     public double getPrice() {
         return 0;
     }

     public double getDiscountApplied(Product p){
         return netPrice() - p.getDiscountPercentage();

     }
     public double netPrice(){
         return netPrice();

     }

//     public double getDiscountApplied(){
//        double i =  getPrice()-(getPrice() * getDiscountPercentage()/100);
//        return i;
//
//    }
//    public double netPrice(){
//        return getPrice();
//
//    }



    @Override
     public String toString() {
         return "Book{" +
                 "Title='" + Title + '\'' +
                 ", author='" + author + '\'' +
                 ", genere='" + genere + '\'' +
                 '}';
     }
 }
