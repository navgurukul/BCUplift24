import org.uplift.ordermanagementsystem.Beverage;
import org.uplift.ordermanagementsystem.Order;
import org.uplift.ordermanagementsystem.OrderItems;
import org.uplift.ordermanagementsystem.OrderManagement;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.SortedSet;

public class Main {


    public static <OrderManagementSystem> void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book book5 = new Book();
        Book book6 = new Book();
        Beverage beverage1 = new Beverage("Chocolate Shake", 1000, "Chocolate");
        Beverage beverage2 = new Beverage("Cold drink", 1500, "Pepsi");
        Beverage beverage3 = new Beverage("Milk", 100, "Badam");
        Beverage beverage4 = new Beverage("Coffee", 500, "Cold");
        Beverage beverage5 = new Beverage("Tea", 600, "Green");
        Beverage beverage6 = new Beverage("Juice", 800, "Apple");


        // Display product descriptions
        System.out.println("Book description: " + book1.toString());
        System.out.println("Beverage description: " + beverage1.getProductDescription());

        // Create an Order
        OrderItems order = new OrderItems();
        order.setShippingAddress("Chennai");

        // Add products to the order
        order.addProduct(book1);
        order.addProduct(book2);

        // Calculate order cost
        double totalCost = order.calculateOrderCost();
        System.out.println("Total order cost: " + totalCost);

        // Create an OrderManagementSystem
        OrderManagement orderManagement = new OrderManagement();

        // Place the order through the OrderManagementSystem
//        orderManagement.placeOrder();

        // Print unique shipped cities
        System.out.println("Unique shipped cities:");
        orderManagement.printUniqueShippedCities();
    }


    }
