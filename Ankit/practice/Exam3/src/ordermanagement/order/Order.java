package ordermanagement.order;

import ordermanagement.ShippingAddress;
import ordermanagement.exception.OutOfStockException;
import ordermanagement.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private long id;
    private ShippingAddress shippingAddress;
    private List<OrderItems> items = new ArrayList<>();
    private Map<String,Double> zoneShippingCharges = new HashMap<>();
    private static Map<Product,Integer> inventoryMap = new HashMap<>();

    public Order(long id, ShippingAddress shippingAddress) {
        this.id = id;
        this.shippingAddress = shippingAddress;
        zoneShippingCharges.put("South",100.0);
        zoneShippingCharges.put("North",105.0);
        zoneShippingCharges.put("West",70.0);
        zoneShippingCharges.put("East",110.0);
    }

    public void addProductToInventory(Product product, int stock){
        inventoryMap.put(product,stock);

    }

    public void addProduct(Product product, int qty) throws OutOfStockException {
          int currentStock = inventoryMap.get(product);
          if(qty > currentStock){
              throw new OutOfStockException(product.getProductDescription() + " product is out of stock.");
          }
          OrderItems orderItems = new OrderItems(product,qty);
          items.add(orderItems);
          inventoryMap.put(product,currentStock-qty);
    }
    public ShippingAddress getShippingAddress(){
        return shippingAddress;
    }
    public List<OrderItems> getItems(){
        return items ;
    }
    public double getPrice(){
        double totalPrice =0;
        for(OrderItems i: items){
            totalPrice+= i.getPrice();
        }
        return totalPrice+zoneShippingCharges.get(shippingAddress.getZone());
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }

    public long getId() {
        return id;
    }
}
