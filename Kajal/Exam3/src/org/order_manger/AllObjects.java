package org.order_manger;

import org.orders.Order;
import org.orders.OrderItems;
import org.orders.ShippingAddress;
import org.products.Beverage;
import org.products.Book;
import org.products.Product;

public class AllObjects {
    public void objects(){
        Product p1 = new Book("Book1", "Author1", "Thrilled", 20031, 200.0);
        Product p2 = new Book("Book2", "Author2", "Comedy",786754, 350);
        Product p3 = new Beverage("Tea", 50, "Lemon", 76543, 100.0);
        Product p4 = new Beverage("Shake", 100, "Banana", 87659, 150.0);

        Order o = new Order(123456);
        o.addProduct(p1);
        o.addProduct(p2);
        o.addProduct(p3);
        o.addProduct(p4);

        Order o1 = new Order(897643);
        o1.addProduct(p4);
        o1.addProduct(p2);
        o1.addProduct(p1);

        OrderManagement om = new OrderManagement();
        om.addOrders(o);
        om.addOrders(o1);

        ShippingAddress sa = new ShippingAddress("G-55", "Sangam Vihar", "Delhi", 110090);
        ShippingAddress sa1 = new ShippingAddress("Greater Kailash", "New Noida", "Noida", 110021);
        o.getShippingAddress(sa);
        o1.getShippingAddress(sa1);

        for (Order order : om.getOrders()){
            for (OrderItems items : order.getItems()){
                System.out.println(items.getProduct().getProductDescription());
            }
        }

        System.out.println(om.getUniqueShipedCities());


//        for (OrderItems oi : o.getItems()){
//            System.out.println(oi.getProduct().getProductDescription());
//        }
//        System.out.println(o.getPrice());
    }
}
