package system.management.order;

import java.util.ArrayList;

public class Order {
    private long id;
    private ArrayList<OrderItems> items;
    ShippingAddress shippingAddress;
    ZoneShippingCharges zoneShippingCharges;

    public Order(long id, ArrayList<OrderItems> items,ShippingAddress shippingAddress,ZoneShippingCharges zoneShippingCharges) {
        this.id = id;
        this.items = items;
        this.shippingAddress=shippingAddress;
        this.zoneShippingCharges=zoneShippingCharges;
    }

    public void addProduct(OrderItems orderItems){
        items.add(orderItems);
    }
    public ShippingAddress getShippingAddress(){
        return shippingAddress;
    }
    public  double getPrice(){
        int price=0;
        for(OrderItems orderItems:items){
            price+=orderItems.getPrice();
        }
        String  Zone= shippingAddress.getZone();
        int shippingCostForZone=(zoneShippingCharges.getMapOfZoneShippingCharges().get(Zone));
        return price+shippingCostForZone;
    }

    public long getId() {
        return id;
    }

    public ArrayList<OrderItems> getItems() {
        return items;
    }
    public String getZone(){
         String  Zone= shippingAddress.getZone();
         return Zone;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", items=" + items +
                ", shippingAddress=" + shippingAddress +
                ", zoneShippingCharges=" + zoneShippingCharges +
                '}';
    }
}
