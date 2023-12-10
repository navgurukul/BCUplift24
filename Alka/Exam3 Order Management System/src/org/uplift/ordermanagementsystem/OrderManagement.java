package org.uplift.ordermanagementsystem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class OrderManagement {

    ArrayList<OrderItems> items;



    public void addProducts(Product product){
        ArrayList listOfProducts = new ArrayList<>();
        listOfProducts.addAll((Collection) product);
    }

    public void getListOfProducts() {
        Product[] listOfProducts = new Product[0];
        for(Product i : listOfProducts){
            System.out.println(i);
        }
    }
    public void placeOrder(Order order) {
        // Add order to the list of ordersArrayList
         ArrayList listOfOrdereditems = new ArrayList<>();
        listOfOrdereditems.addAll((Collection) order);
    }

    public void getListOfOrdereditems() {
        Product[] listOfOrdereditems = new Product[0];
        for(Product i : listOfOrdereditems){
            System.out.println(i);
        }
    }

    public void printUniqueShippedCities() {
        HashSet<String> shippedCities = new HashSet<>();
        for (OrderItems order : items) {
            shippedCities.add(order.getShippingAddress());
        }
        System.out.println("Unique shipped cities: " + shippedCities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderManagement that = (OrderManagement) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        return "OrderManagement{" +
                "order=" + items +
                '}';
    }

    public double calculateTotalOrderCost(Order order) {
        return 0.0;
    }
}
