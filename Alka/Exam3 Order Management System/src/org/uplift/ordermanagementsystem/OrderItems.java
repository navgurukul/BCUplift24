package org.uplift.ordermanagementsystem;

import java.awt.print.Book;
import java.util.ArrayList;

public class OrderItems {

    ArrayList<Product> product;
    private int quantity;

    public OrderItems() {

    }


    public ArrayList<Product> getProduct() {
        return product;
    }

    public OrderItems(ArrayList<Product> product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }



    public int getQuantity() {
        return quantity;
    }

    public double getPrice(Product p){
        double orderItemPrice = p.getPrice() - p.getDiscountPercentage() * getQuantity();
        return orderItemPrice;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public double calculateOrderCost() {
        return calculateOrderCost();
    }

    public String getShippingAddress() {
        return getShippingAddress();
    }

    public void setShippingAddress(String chennai) {
        System.out.println(chennai);
    }

    public void addProduct(Book book1) {

    }
}
