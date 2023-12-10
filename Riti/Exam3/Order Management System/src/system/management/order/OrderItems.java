package system.management.order;

public class OrderItems {
    private Product product;
    private int quantity;

    public OrderItems(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public double getPrice(){
        double price=product.getPrice();
        double discountPercentage=product.getDiscountApplied();

        return ((price-((price*discountPercentage)/100))*quantity);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
