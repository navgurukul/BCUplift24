package order;

import order.products.Product;
import order.shippingaddress.ShippingAddress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private long id;
    private ArrayList<OrderItems> items;
    private static final Map<String, Double> zoneShippingCharges = new HashMap<>();

    private ShippingAddress shippingAddress;

    public Order(long id, ShippingAddress shippingAddress) {
        this.id = id;
        this.shippingAddress = shippingAddress;

        items = new ArrayList<>();

        zoneShippingCharges.put("East", 100.0);
        zoneShippingCharges.put("North", 50.0);
        zoneShippingCharges.put("South", 200.0);
        zoneShippingCharges.put("West", 150.0);
    }

    public void addProduct(Product product, int quantity){
        OrderItems orderItems = new OrderItems(product, quantity);
        items.add(orderItems);
    }

    public ArrayList<OrderItems> getItems() {
        return items;
    }

    public ShippingAddress getShippingAddress(){
        return shippingAddress;
    }

    public double getPrice(){
        double totalPrice = 0;
        for (OrderItems ot : items){
            totalPrice += ot.getPrice();
        }
        return totalPrice += zoneShippingCharges.get(shippingAddress.getZone());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}
