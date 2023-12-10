import org.uplift.orderMangement.Beverage;
import org.uplift.orderMangement.Book;
import org.uplift.orderMangement.OrderItems;
import org.uplift.orderMangement.ShippingAddress;

public class Main {
    public static void main(String[] args) {

        Book b1= new Book("book1","author1","comedy");
        Book b2= new Book("book2","author2","suspense");
        Book b3= new Book("book3","author3","Horror");
        Book b4= new Book("book4","author4","romantic");

        Beverage bv1= new Beverage("bav1",100,"chocolate");
        Beverage bv2= new Beverage("bav2",250,"Strawberry");
        Beverage bv3= new Beverage("bav3",200,"butterScotch");
        Beverage bv4= new Beverage("bav4",150,"Lemon");
        Beverage bv5= new Beverage("bav5",500,"mango");

        OrderItems oi1= new OrderItems(b1,25);
        OrderItems oi2= new OrderItems(b2,30);
        OrderItems oi3= new OrderItems(bv1,45);
        OrderItems oi4= new OrderItems(bv2,50);
        OrderItems oi5= new OrderItems(bv3,20);

        ShippingAddress s1= new ShippingAddress("123"," new Delhi", "Delhi",111111,"north zone");
        ShippingAddress s2= new ShippingAddress("456","Banglore", "karnataka",22222,"south zone");
        ShippingAddress s3= new ShippingAddress("789","Mumbai", "Maharashtra",33333,"West zone");
        ShippingAddress s4= new ShippingAddress("321","Kolkata", "west bangal",44444,"east zone");

    }
}