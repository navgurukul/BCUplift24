import org.orderManagement.orderdetails.OderIterms;
import org.orderManagement.orderdetails.Order;
import org.orderManagement.product.Beverage;
import org.orderManagement.product.Book;
import org.orderManagement.zone.ShippingAddress;
import org.orderManagement.zone.Zone;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1,"abc","John","XYZJKK",200);
        Book book2 = new Book(2,"bcd","abc","XKK",100);

        Beverage beverage1 = new Beverage(12,"abc","hhjuyhn",98766544L,300);

        ShippingAddress shippingAddress = new ShippingAddress("Abc", "bcd","Mumbai",9087L, Zone.WEST);

        OderIterms orderitem1= new OderIterms(book1,3);
        OderIterms orderitem2= new OderIterms(book2,2);
        OderIterms orderitem3= new OderIterms(beverage1,3);

        Order order1 = new Order(12,shippingAddress);
        order1.addProduct(orderitem1);
        order1.addProduct(orderitem2);
        order1.addProduct(orderitem3);

        System.out.println(order1.getprice());
    }
}