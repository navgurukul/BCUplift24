import org.exam3.Beverage;
import org.exam3.Book;
import org.exam3.OrderManagementSystem;
import org.junit.jupiter.api.Order;

//import static jdk.tools.jlink.internal.plugins.PluginsResourceBundle.getDescription;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("SELFCARE", "Ramh", "The 5am club", 55);
        Book book1 = new Book("Fiction", "Jones", "the monk", 50);
        System.out.println(book.getDescription());
        System.out.println(book1.getDescription());

        Beverage beverage = new Beverage("Nimbu", "PaperBoat", 1000, 5);
        System.out.println(beverage.getDescription());

        OrderManagementSystem oms = new OrderManagementSystem ();
        oms.placeOrder(book, 2, "Chennai");
        oms.placeOrder(beverage, 3, "Mumbai");
        oms.placeOrder(book, 1, "Delhi");

        oms.printUniqueShippedCities();
//        Order ore=new Order();
//
//        ore.shippingCost();
    }
}



