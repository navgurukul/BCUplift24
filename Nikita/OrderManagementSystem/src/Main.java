import org.Uplift24.Exam3.*;

import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception{

        Product p1=new Book("Mrutyunjay","Shivaji savant","NonFiction",900);
        Product p2=new Book("Mahashweta","Sudha Murti","NonFiction",700);
        Product p3=new Book("Shamchi aai","sane guruji","Fiction",1000);
        Product p4=new Book("Yayati","V.D.savarker","Fiction",745);

        Product p5=new Beverage("Brand1",500,"orange",970);
        Product p6=new Beverage("Brand2",1500,"pineapple",530);
        Product p7=new Beverage("Brand3",2000,"butterscotch",999);
        Product p8=new Beverage("Brand4",870,"stobery",452);

        OrderItems items1=new OrderItems(p1,5);
        OrderItems items2=new OrderItems(p4,6);
        OrderItems items3=new OrderItems(p5,2);
        OrderItems items4=new OrderItems(p2,9);
        OrderItems items5=new OrderItems(p7,4);

        ArrayList<OrderItems> orderItems=new ArrayList<>(Arrays.asList(items1,items2,items3,items4,items5));
        ShippingAddress address=new ShippingAddress("sarjapur","Banglore",44354656,"North");

        Order order1=new Order(2324343,orderItems,address);
        order1.getPrice();
        order1.getShippingAddress();
        order1.addProduct(items2);
        order1.addProduct(items1);

        OrderManagement orderManagement=new OrderManagement();
        orderManagement.addOrders(order1);
        System.out.println(orderManagement.getUniqueShippedCities());



    }
}