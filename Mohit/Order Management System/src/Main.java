import org.order.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Book b1=new Book("one","ram Das","Todo",200);
        Book b2=new Book("Ramayana","R.k Nivash","Todo",180);
        Book b3=new Book("Atomic habbit","Surdash","Aarogi",200);
        System.out.println(b1.getPrice());

        Beverage be1=new Beverage("sugar Water",1233,"lemon",100);
        Beverage be2=new Beverage("SweetSalted water",1213,"soda",150);
        Beverage be3=new Beverage("sugar Water",1633,"lemone",120);

        ShipingAddress s1=new ShipingAddress("low Street"," new delhi","near mataji temple",110033,"NORTH");
        ShipingAddress s2=new ShipingAddress("New kila market","Adarsh nagar","Sabji mandi Street 2",110053,"NORTH");
        ShipingAddress s3=new ShipingAddress("Big Bazar","Dorakua","near mataji temple",110343,"SOUTH");

        s1.addToCityzoneMap("new delhi","NORTH");
        s1.addToCityzoneMap("Adarsh nagar","NORTH");
        System.out.println(s1.getCityZoneMap());

        OrderItem om=new OrderItem(b1,10);
        OrderItem om2=new OrderItem(b2,5);
        OrderItem om3=new OrderItem(b3,12);

        Order o1=new Order(123);
        o1.addProduct(om);
        o1.addProduct(om2);
        o1.addProduct(om2);

        o1.addShipingchatges(s1.getZone(),20);
        o1.addShipingchatges(s2.getZone(),40);
        System.out.println(o1.getPrice(om,"NORTH"));


        System.out.println(o1.getOrderItemList());

        OrderManagementSystem oms=new OrderManagementSystem();
        oms.addOrder(o1);
        System.out.println(oms.getOrderList());



    }
}