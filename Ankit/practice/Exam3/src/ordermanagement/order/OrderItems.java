package ordermanagement.order;

import ordermanagement.product.Product;

import java.util.Objects;

public class OrderItems {
    private Product product ;
    private int quantity;

    public OrderItems(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getPrice(){
        return (product.getPrice() - product.getDiscountApplied()) * quantity;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
    public int getQuantity(){
        return quantity;
    }
    public Product getProduct(){
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItems that)) return false;
        return getQuantity() == that.getQuantity() && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct(), getQuantity());
    }
}
