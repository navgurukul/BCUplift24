import org.*;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {


        Product p1 = new Book(101,1000.0,"Book1","Ravi Sharma","genere");
        Product p2 = new Book(102,1000.0,"Book2","Ravi Sharma","genere");
        Product p3 = new Book(103,1000.0,"Book3","Ravi Sharma","genere");

        Product p4 = new Beverage(104,1000.0,"make1",11L, "choclate");
        Product p5 = new Beverage(105,1000.0,"make2",10L,"choclate");
        Product p6 = new Beverage(105,1000.0,"make3",12L,"choclate");

        List<Orderitems> orderitemsList = new ArrayList<>();


        orderitemsList.add(new Orderitems(p1,1));
        orderitemsList.add(new Orderitems(p2,1));
        orderitemsList.add(new Orderitems(p3,1));
        orderitemsList.add(new Orderitems(p4,1));
        orderitemsList.add(new Orderitems(p6,1));



        Order order1 = new Order((long) 1123486464.0,orderitemsList);
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);

        OrderManagement ordermanagement = new OrderManagement(orderList);

        order1.addProduct(p3);
        List<Orderitems> orderitems = order1.getItems();

        for (Orderitems o1 : orderitems){
            System.out.println(o1.getProduct().getProductDescription());
        }

    }
}