import order.Order;
import order.products.Beverage;
import order.products.Book;
import order.products.Product;
import order.shippingaddress.ShippingAddress;
import orderManagement.OrderManagement;

public class Main {
    public static void main(String[] args) {
        OrderManagement om = new OrderManagement();

        ShippingAddress shippingAddress = new ShippingAddress("NavGurukul " +
                "Sarjapur Campus", "HalnayakanaHalli", "Bangalore", 110287);

        ShippingAddress shippingAddress2 = new ShippingAddress("NavGurukul " +
                "Delhi Campus", "Dwarka", "Delhi", 110062);

        Order order1 =new Order(11111, shippingAddress);
        Product book = new Book(1, 500.0, "1921", "Stephen King", "Horror");
        Product beverage = new Beverage(1, 100, "CafeCoffeeDay", 50, "cold coffee");
        order1.addProduct(book, 2);
        order1.addProduct(beverage, 1);

        System.out.println("Total price for first order: "+order1.getPrice());

        Order order2 = new Order(22222, shippingAddress2);
        order2.addProduct(book, 2);
        order2.addProduct(beverage, 1);

        System.out.println("Total price for second order: "+order2.getPrice());

        Order order3 = new Order(33333, shippingAddress2);
        order3.addProduct(book,1);

        System.out.println("Total price for third order: "+order3.getPrice());

        om.placeOrder(order1);
        om.placeOrder(order2);
        om.placeOrder(order3);

        System.out.println("Uniquely Shipped cities: "+om.getUniqueShippedCities());

        System.out.println("All orders: ");
        for (Order o: om.getOrders()){
            System.out.println(o);
        }

    }
}