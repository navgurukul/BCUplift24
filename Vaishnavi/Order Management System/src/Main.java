import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {

        Product product1 = new Book("Bhagvatgita","Vyas","Autobiography");
        Product prodcut2 = new Beverage("Fruti",100,"Mango");
        Product product3 = new Book("Ramayana","Valmiki","Autobiography");
        Product product4 = new Beverage("Sprite",200,"Vanilla");
        Product product5 = new Book("Head First Java","Katthy","Fiction");


        Zone zone = new Zone();

        ShippingAddress shippingAddress1 = new ShippingAddress("Sangludkar Nagar,Amravati, Maharashtra","Sangludkar Nagar","Amravati",444803,"NORTH");
        ShippingAddress shippingAddress2 = new ShippingAddress("Shivaji Nagar,Nagpur, Odhisha","Shivaji Nagar","Nagpur",444103,"SOUTH");
        ShippingAddress shippingAddress3 = new ShippingAddress("Gajiyabad , Delhi","Gurgaon","Delhi",444573,"EAST");
        ShippingAddress shippingAddress4 = new ShippingAddress("HallyanKalli, Sarjapur, Banglore","HallyanKalli","Banglore",444235,"WEST");


        OrderItems orderItems1 = new OrderItems(product1,2);
        OrderItems orderItems2 = new OrderItems(prodcut2,4);
        OrderItems orderItems3 = new OrderItems(product3,5);
        OrderItems orderItems4 = new OrderItems(product4,7);
        OrderItems orderItems5 = new OrderItems(product5,8);



        Order order1 = new Order(shippingAddress1);
        order1.addProduct(orderItems1);
        order1.addProduct(orderItems2);

        Order order2 = new Order(shippingAddress2);
        order2.addProduct(orderItems2);
        order2.addProduct(orderItems3);

        Order order3 = new Order(shippingAddress3);
        order3.addProduct(orderItems3);
        order3.addProduct(orderItems4);
        order3.addProduct(orderItems5);

        Order order4 = new Order(shippingAddress4);
        order4.addProduct(orderItems1);
        order4.addProduct(orderItems3);
        order4.addProduct(orderItems5);






        List<Order> orders = new ArrayList<>();

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);


        OrderManagement orderManagement = new OrderManagement(orders);


        double totalPrice= 0.0;



        for(Order order : orderManagement.getOrders()){
            System.out.println("Shipping Address : " + order.getShippingAddress());
            for(OrderItems orderItems : order.getItems()){
                System.out.println(orderItems+"\n"+"Price  : " +orderItems.getPrice());
                totalPrice = totalPrice + orderItems.getPrice();
            }

            System.out.println("\n");
            System.out.println("Total Price Of Order Item Is : " +totalPrice+"\n\n");
            System.out.println("\n<=============================================================================================>\n\n\n");
            totalPrice = 0.0;
        }



        }





}