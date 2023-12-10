import org.OrderManagementSystem.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        //Objects of Book
        Product b1 = new Book(1,"Pride and Prejudice", "Jane Austen", "Fiction", 200);
        Product b2 = new Book(2,"The Great Gatsby", "Scott", "Fiction", 300);
        Product b3 = new Book(3,"Nineteen EightyFor", "George Oewell", "Fiction",250);
        Product b4 = new Book(4,"Pride and Prejudice", "Jane Austen", "Non-Fiction",160);
        Product b5 = new Book(5,"The Great Gatsby", "Scott", "Non-Fiction", 130);
        Product b6 = new Book(6,"Nineteen EightyFor", "George Oewell", "Non-Fiction", 600);

        //Object of Beverages
        Product p1 = new Beverages("Nimbu",300, "Paperboat", 20);
        Product p2 = new Beverages("Maaza",200, "Paperboat", 30);
        Product p3 = new Beverages("ResBull",150, "RedBull", 150);
        Product p4 = new Beverages("Nimbu",200, "Paperboat", 35);
        Product p5 = new Beverages("Maaza",250, "Paperboat", 50);
        Product p6 = new Beverages("ResBull",100, "RedBull",300);


        //adding quantity of books in orderItem class
        OrderItem o1 = new OrderItem(b1, 5);
        OrderItem o2 = new OrderItem(b1, 10);
        OrderItem o3 = new OrderItem(b1, 15);
        OrderItem o4 = new OrderItem(b1, 20);
        OrderItem o5 = new OrderItem(b1, 25);
        OrderItem o6 = new OrderItem(b1, 35);

        //adding quantity of beverages in orderItem class
        OrderItem op1 = new OrderItem(p1, 5);
        OrderItem op2 = new OrderItem(p2, 10);
        OrderItem op3 = new OrderItem(p3, 15);
        OrderItem op4 = new OrderItem(p4, 20);
        OrderItem op5 = new OrderItem(p5, 25);
        OrderItem op6 = new OrderItem(p6, 35);

        // printing the price of books with after discount
        System.out.println(o1.getPrice());


        //Shipping address of product
        ShippingAddress s = new ShippingAddress("colony 01", "Sarjapur", "Bangalore", 556011 );

        Order order = new Order(25631452,new ArrayList<>(), 200);

        order.addProduct(o1);
        order.addProduct(o2);
        order.addProduct(o3);
        order.addProduct(o4);
        order.addProduct(o5);
        order.addProduct(o6);

        //list of all products
        System.out.println(order.getItems());


        // price of all products with shipping price
        System.out.println(order.getPrice());



    }
}