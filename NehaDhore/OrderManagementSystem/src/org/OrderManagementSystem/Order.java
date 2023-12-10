package org.OrderManagementSystem;

import java.util.*;
import java.util.function.Supplier;

public class Order {
    private long id;
    List<OrderItems> items = new ArrayList<>();
    Set<Product> productSet = new HashSet<>();
    Map<String,Double> ZoneShippingCharges = new HashMap<>();

    public Order(long id) {
        this.id = id;

    }



    public Supplier<String> addProduct(Product P) {

        productSet.add(P);
        System.out.println("Your product has been added to the list.....!");

        return null;
    }

    public short getId() {
        System.out.println("Order Id is: "+ id);
        return 0;
    }
    public double getPrice(){
        return getPrice();
    }

    public String getShippingAddress() {
//        ShippingAddress s = new ShippingAddress();
        return getShippingAddress();
    }

    public List<OrderItems> getItems() {
        return items;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }
//    public double getPrice() {
//        Product p = new Product()
//        @Override
//        public String getProductDescription(Product p) {
//            return p.getPrice(), .getId(), p.getProductDescription();
//        }
//
//        @Override
//        public double getDiscountPercentage () {
//            return p.getDiscountPercentage();
//        }
//
//        Product p1 = p;
//        @Override
//        public double getPrice(Product p) {
//            return p.getPrice();
//        }
    }



