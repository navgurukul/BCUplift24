package OnlineShopping;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private long orderId;
    private List<OrderItems> orderItemsList;

    public Order(long orderId) {
        this.orderId = orderId;
        this.orderItemsList = new ArrayList<>();
    }

    public long getOrderId() {
        return orderId;
    }

    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderItemsList=" + orderItemsList +
                '}';
    }
}
