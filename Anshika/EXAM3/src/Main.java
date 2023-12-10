import org.uplift.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {



        Book book1=new Book("love of life","Vijay nath","biography");
        Book book2=new Book("Goals","Deepanjali sharma","motivational");
        Book book3=new Book("hope will never die","Prayag singh","general");


        Beverage beverage1=new Beverage("lemon water",1000,"lemon with mint");
        Beverage beverage2=new Beverage("milky shake",1500,"almond");
        Beverage beverage3=new Beverage("kulti",1200,"kala-khatta");

        Orderitems items=new Orderitems(book1,2);


        ShippingAddress shippingAddress=new ShippingAddress("t-265 c/10","chirag delhi","delhi",110012,"SOUTH");


    }
}