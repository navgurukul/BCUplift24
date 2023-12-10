import org.OrderManagementSystem.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Book b1=new Book(111,500,"Java Book","Abc","xyz");
        Book b2=new Book(222,1000,"The Immortals of Melhua","Amish","Diction");

        Beverage a1=new Beverage(11,50,"PaperBoat",1000,"Nimbu");
        Beverage a2=new Beverage(22,60,"PaperBoat",1000,"Kaccha Mango");

        OrderItems ot1=new OrderItems(b2,10);
        ShippingAddress address=new ShippingAddress("aaaaaaaaaaaa","bbbbbbbbbb","Mumbai",111111);
        address.ShippingAddressZone();
        Order order=new Order(12345,address);
        OrderManagement om=new OrderManagement();
        om.addOrder(order);
        System.out.println(om.getOrders());
        System.out.println(b1);
        System.out.println(a1);
        System.out.println(b2);
        System.out.println(a2);
        System.out.println(address.getZoneMap());




    }
}