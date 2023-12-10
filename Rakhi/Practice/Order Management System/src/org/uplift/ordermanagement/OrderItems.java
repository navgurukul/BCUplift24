package org.uplift.ordermanagement;

public class OrderItems {
    private Product product;
    private int qualtity;

    public OrderItems(Product product, int qualtity) {
        this.product = product;
        this.qualtity = qualtity;
    }

    public double getPrice(){
        return product.netPrice()- product.getDiscountApplied()*qualtity;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "product=" + product +
                ", qualtity=" + qualtity +
                '}';
    }
}
