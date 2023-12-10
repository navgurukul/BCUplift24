import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private long id;
    List<OrderItems> items = new ArrayList<>();
    Map<String,Double> ZoneShippingCharges = new HashMap<>();
    ShippingAddress shippingAddress ;
    Double netPrice = null;

    Zone zone = new Zone();


    public Order(ShippingAddress shippingAddress){
        this.id = (int) Math.random();
        this.shippingAddress = shippingAddress;
        this.ZoneShippingCharges = zone.getZoneShippingCharges();
    }


    public void addProduct(OrderItems product){
        items.add(product);
    }

    public ShippingAddress getShippingAddress(){
        return shippingAddress;

    }

    public List<OrderItems> getItems(){
        return items;
    }

    public Double getPrice(){


        for(OrderItems item : items){
            netPrice = netPrice + item.getPrice()  + ZoneShippingCharges.get(shippingAddress.getZone());

        }

        return netPrice;

    }

    @Override
    public String toString() {
        return "\nOrder : \n" +
                "id=" + id +
                ", items=" + items +
                "\n"+ "shippingAddress :" + shippingAddress+
                "\n";
    }
}
