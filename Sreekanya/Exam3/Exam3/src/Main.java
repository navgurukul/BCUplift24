import org.ordermanagement.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product productBook1=new Book(200,0.1,"Book1","genere1","author1");
        Product productBook2=new Book(300,0.1,"Book2","genere2","author2");
        Product productBeverage1=new Beverage(100,0.2,"make1",500,"flavour1");
        Product productBeverage2=new Beverage(50,0.2,"make2",200,"flavour2");
        //productBeverage1.getDiscountApplied();

//        OrderItems oi=new OrderItems(productBook1,20);
//        OrderItems oi1=new OrderItems(productBook2,10);
//        OrderItems oi3=new OrderItems(productBeverage1,5);
//        OrderItems oi4=new OrderItems(productBeverage1,15);
        Order order=new Order(5,"Bangalore");
        Order order1=new Order(7,"Chennai");
        Order order2=new Order(10,"Noida");
        Order order3=new Order(8,"Kolkata");
        //List<Order> orderItems=new ArrayList<>();
        order.addProduct(productBook1);
        order.addProduct(productBook2);
        order.addProduct(productBeverage1);
        order.addProduct(productBeverage2);

        ShippingAddress sa=new ShippingAddress(order.getCity());
        ShippingAddress sa1=new ShippingAddress(order1.getCity());
        ShippingAddress sa2=new ShippingAddress(order2.getCity());
        ShippingAddress sa3=new ShippingAddress(order3.getCity());
        OrderManagement orm=new OrderManagement();







        //System.out.println("Hello world!");
    }
}