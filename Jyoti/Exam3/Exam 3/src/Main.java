
import org.management.*; // Book, Beverage, Order
import java.util.*; // List, Set, HashSet, ArrayList

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        Book bookOrder = new Book("Fiction", "Amish", "The Immortals of Melhua", 50.0, 2);
        Beverage beverageOrder = new Beverage("Mango", "PaperBoat", 1000, 5.0, 3);

        orders.add(new Order(bookOrder, "Chennai"));
        orders.add(new Order(beverageOrder, "Mumbai"));
        orders.add(new Order(bookOrder, "Delhi"));

        for (Order order : orders) {
            double totalCost = order.calculateOrderCost();
            System.out.println(order.product.getDescription());
            System.out.println("Shipping Address: " + order.getShippingCity());
            System.out.println("Total Cost: $" + totalCost);
            System.out.println();
        }
        Set<String> uniqueCities = new HashSet<>();
        for (Order order : orders) {
            uniqueCities.add(order.getShippingCity());
        }
        System.out.println("Uniquely Shipped Cities:");
        for (String city : uniqueCities) {
            System.out.println(city);
        }
    }
}
