import org.ordermanagementsystem.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1,500,10,"Tiny habits","James clear","Self helped");
        Beverage beverege1 = new Beverage(1,200,20,"nimbu",500,"paperBoat");

        OrderItems orderBook = new OrderItems(book1,2);
        OrderItems orderBeverage = new OrderItems(beverege1,1);
        Order first = new Order(1L);
        first.addProduct(orderBook);
        first.addProduct(orderBeverage);
        System.out.println(first.getItems());

        List<Order> orders = List.of(first);

        OrderManagement orderManagement = new OrderManagement(orders);
        System.out.println(orderManagement.getOrders());

        System.out.println(book1.getProductDescription());
        System.out.println(book1.getPrice());
        System.out.println(book1.netPrice());

        System.out.println(beverege1.getProductDescription());
        System.out.println(beverege1.getPrice());
        System.out.println(beverege1.netPrice());

        System.out.println("price for two books;- " + orderBook.getPrice());

        ShippingAdress customer1 = new ShippingAdress("h.no 37","sarjapur","Bangluru",12L,ShippingAdress.SOUTH);
        ShippingAdress customer2 = new ShippingAdress("h.no 85","azadpur","Delhi",10L,ShippingAdress.NORTH);
        customer1.getIntoCityZoneMap();
        customer2.getIntoCityZoneMap();

    }
}