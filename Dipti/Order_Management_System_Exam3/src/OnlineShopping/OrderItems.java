package OnlineShopping;

import java.util.ArrayList;
import java.util.List;

public class OrderItems {
    private Product product;
    private int quantity;
   // private List<OrderItems> orderList;

    public OrderItems(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        //  this.orderList=new ArrayList<OrderItems>();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

//    public List<OrderItems> getOrderList() {
//        return orderList;
//    }

//    public void addProduct(OrderItems o) {
//        orderList.add(o);
//    }
    @Override
    public String toString() {
        return "OrderItems{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
