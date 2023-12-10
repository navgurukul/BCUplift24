import org.OrderManagementSystem.*;

import java.awt.print.Book;

public class Main {
    public static void main(String[] args) {

        Beverage B = new Beverage(500,"Lemon");
        Beverage B1 = new Beverage(1000,"Mango");
        ShippingAddress s = new ShippingAddress("MG Square","Mumbai","Kalyan",4004);
        ShippingAddress s1 = new ShippingAddress("NG Square","Delhi","Noida",5005);


        Order O = new Order(1);

        OrderItems i = new OrderItems(B,2);
        OrderItems i1 = new OrderItems(B1,3);



        O.addProduct(B);
        O.addProduct(B1);
        O.getId();
        i.getQuantity();
        i.getPrice();





    }
}