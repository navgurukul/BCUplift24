import org.ExamNo3.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Product p = new Book(1,500.0,0.1,"Wings of fire","APJ abdul kalam","Motivation");
        System.out.println("Description of Product : " + p.getProductDescription());
        System.out.println("Price after applying discount  : " + p.getDiscountApplied());
        System.out.println("Total price : " + p.netPrice());

        Product p1 = new Beverage(5,400,0.2,"PaperBoat",1000,"Kiwi");
        System.out.println(p1.getDiscountApplied());
        System.out.println(p1.getProductDescription());
        System.out.println(p1.netPrice());

        ShippingAddress s = new ShippingAddress("ABC Zone Chennai","ABC Zone","Chennai",444101,"SouthZone");

        Order order = new Order(2);
        System.out.println(order.getShippingAddress(s));
        System.out.println(order.calculateDistance());
        System.out.println(order.calculateShippingCharges());
        System.out.println(order.getPrice(p));



        Orderitems orderitem = new Orderitems(p,4);

        OrderManagement om = new OrderManagement();
        //order.addProductFromOrderitems(orderitem);
        om.addOrder(order);
        System.out.println(om.getOrders());

    }
}