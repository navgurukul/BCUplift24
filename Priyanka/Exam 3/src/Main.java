import org.uplift.exam3.*;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("The Immortals of Melhua","Amish","Fiction",10,50);
        Book b2 = new Book("The Nightmare","Amisha","Fiction",20,60);

        Beverage bv1 = new Beverage("PaperBoat",1000,"Nimbu",20,40);

        OrderItems orderItem1 = new OrderItems(b1,5);
        OrderItems orderItem2 = new OrderItems(b2,3);
        OrderItems orderItem3 = new OrderItems(bv1,5);

        ShippingAddress sd1 = new ShippingAddress("xyz","yyy","Chennai",1234567);
        ShippingAddress sd2 = new ShippingAddress("uyt","zzz","Mumbai",2345567);
        ShippingAddress sd3 = new ShippingAddress("nvf","kkk","Mumbai",2345567);
        sd1.addtoMap();

        Order o1 = new Order(12345,orderItem1,sd1);
        Order o2 = new Order(2345,orderItem2,sd2);
        Order o3 = new Order(6544,orderItem3,sd3);

        o1.addOrderItems(orderItem1);
        o2.addOrderItems(orderItem2);
        o3.addOrderItems(orderItem3);

        OrderManagement om = new OrderManagement();
        om.addOrder(o1);
        om.addOrder(o2);
        om.addOrder(o3);

        Set<String> city = om.getUniqueShippedCities();

        for (String s : city) {
            System.out.println(s);
        }
    }
}