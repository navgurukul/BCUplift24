import org.uplift.ordermanagementsystem.*;

public class Main {
    public static void main(String[] args) {
        Book b = new Book(1, 30.0, 10.0, "The Immortals of Melhua", "Amish", "Fiction");
        Product bever = new Beverage(2, 5.0, 20.0, "PaperBoat", 1000, "Nimbu");


        ShippingAddress a1 = new ShippingAddress("123 Main St", "Downtown", "Chennai", 600001, "South");
        ShippingAddress a2 = new ShippingAddress("456 Oak St", "Suburb", "Mumbai", 400001, "West");

        Order o1 = new Order(101, a1);
        Order o2 = new Order(102, a2);

        o1.addProduct(b, 2);
        o2.addProduct(bever, 3);

        CityZoneMap cZM = new CityZoneMap();
        ZoneShippingCharges zoneShippingCharges = new ZoneShippingCharges();

        OrderManagmentSystem oMS = new OrderManagmentSystem(cZM, zoneShippingCharges);
        oMS.addOrder(o1);
        oMS.addOrder(o2);

        o1.addProduct(b, 2);

        oMS.addOrder(o1);
        oMS.getallOrders();
    }
}


