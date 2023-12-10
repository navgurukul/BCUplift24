import org.uplift.*;

import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Map<String,String> cityZoneMap= new HashMap<>();
        cityZoneMap.put("Chennai","south");
        cityZoneMap.put("Bangalore","south");
        cityZoneMap.put("Mumbai","west");
        cityZoneMap.put("Goa","west");
        cityZoneMap.put("Kolkatta","east");
        cityZoneMap.put("Delhi","north");

        Map<String,Double> zoneShippingCharges = new HashMap<>();
        zoneShippingCharges.put("east",80.);
        zoneShippingCharges.put("wast",65.);
        zoneShippingCharges.put("north",90.);
        zoneShippingCharges.put("south",70.);

        Book b1= new Book(1,"two states","Chetan Bhagat","fiction",200.);
        Book b2= new Book(2,"Dogalapan","Ashnir Grover","Motivational",300.);

        Beverage B1 = new Beverage(10,"PaperBoat",1000,"Nimbu",50.);
        Beverage B2 = new Beverage(20,"Appy",500,"Apple",30.);

        OrderItem oI1= new OrderItem(b1,20);
        OrderItem oI2= new OrderItem(B1,10);

        ShippingAddress s1= new ShippingAddress("Ram Nagar","Main Road","Delhi",1234,"north" );
        ShippingAddress s2= new ShippingAddress("Mhada Colony","Khat Road","Mumbai",5678,"west" );

        Order o1= new Order(11,s1);
        o1.addProduct(oI1);
        o1.addProduct(oI2);
        System.out.println(o1.getItems());
        //System.out.println(o1.getPrice());

        Order o2= new Order(22,s2);
        o2.addProduct(oI1);















    }
}